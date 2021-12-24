package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    System.out.printf("Welcome to Amazing Numbers!%n%n");
        boolean even = false;
        boolean odd = false;
        boolean buzz = false;
        boolean duck = false;
        Double num = 0.1;

        do {
            System.out.printf(
                "Supported requests:%n"+
                "- enter a natural number to know its properties;%n"+
                "- enter 0 to exit.%n%n"+
                "Enter a request: >"
            );

            num = scanner.nextDouble();


            if (num % 1 != 0 || num < 0) {
                System.out.println("This number is not natural!");
            } else if (num == 0) {
                break;
            } else {
                int numInt = num.intValue();
                if (numInt % 2 == 0) {
                    even = true;
                } else {
                    odd = true;
                }

                String numStr = String.valueOf(numInt);
                if (numStr.charAt(numStr.length() - 1) == '7' || numInt % 7 == 0) {
                    buzz = true;
                    //                if (numStr.charAt(numStr.length() - 1) == '7' && numInt % 7 == 0) {
                    //                    String output = String.format("%d is divisible by 7 and ends with 7.", numInt);
                    //                    System.out.println(output);
                    //                } else if (numStr.charAt(numStr.length() - 1) == '7') {
                    //                    String output = String.format("%d ends with 7.", numInt);
                    //                    System.out.println(output);
                    //                } else {
                    //                    String output = String.format("%d is divisible by 7.", numInt);
                    //                    System.out.println(output);
                    //                }
                }

                for (int i = 1; i <= numStr.length() - 1; i++) {
                    if (numStr.charAt(i) == '0') {
                        duck = true;
                        break;
                    }
                }



                System.out.printf("Properties of %d%n even: %b%n odd: %b%n buzz: %b%n duck: %b%n", numInt, even, odd, buzz, duck);
            }

        } while (num != 0);
        System.out.println("Goodbye!");
    }
}
