package com.company;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        boolean even = false;
        boolean odd = false;
        boolean buzz = false;
        boolean duck = false;
        boolean palindromic = false;
        boolean gapful = false;
        static Long number;
        static Integer len;

    public static void main(String[] args) {
        System.out.printf(
                "Supported requests:%n"+
                        "- enter a natural number to know its properties;%n"+
                        "- enter two natural numbers to obtain the properties of the list:%n"+
                        "   * the first parameter represents a starting number;%n"+
                        "   * the second parameter shows how many consecutive numbers are to be printed;%n"+
                        "- separate the parameters with one space;%n"+
                        "- enter 0 to exit.%n%n"
        );

        Scanner scanner = new Scanner(System.in);
	    System.out.printf("Welcome to Amazing Numbers!%n%n");


        do {
            boolean even = false;
            boolean odd = false;
            boolean buzz = false;
            boolean duck = false;
            boolean palindromic = false;
            boolean gapful = false;

            System.out.println("Enter a request: > ");

            String input = scanner.nextLine();

            Classifier classifier = new Classifier();

            ArrayList<String[]> properties = new ArrayList<>();
            if (input.contains(" ")) {
                String[] nums = input.split(" ");
                number = Long.valueOf(nums[0]);
                len = Integer.valueOf(nums[1]);
                ArrayList<Long> numbers = new ArrayList<>(len);
                Long seqNum;

                String result = "";
                for (int i = 0; i < len; i++) {
                    seqNum = number + i;
                    numbers.add(seqNum);
                    properties = classifier.classify(seqNum);
                    String reducedProps = "";
                    for (String[] value : properties) {
                        if (value[1] == "true") {
                            reducedProps += value[0] + ", ";
                        }
                    }
                    String subReducedProps = reducedProps.substring(0, reducedProps.length() - 2);
                    System.out.println(seqNum + " is " + subReducedProps);
                }

            } else {
                number = Long.valueOf(input);
                properties = classifier.classify(number);
                System.out.println("Properties of " + input);
                for (String[] value : properties) {
                    System.out.println(value[0] + ": " + value[1]);
                }
//                System.out.printf("Properties of %d%n even: %b%n odd: %b%n", number, properties.get(0)[0], properties.get(1)[1]);
////                        buzz: %b%n duck: %b%n palindromic: %b%n, properties.get(2)[1], properties.get(3)[1], properties.get(4)[1]);
            }


        } while (number != 0);
        System.out.println("Goodbye!");
    }
}
