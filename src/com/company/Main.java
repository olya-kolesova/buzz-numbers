package com.company;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    System.out.printf("Welcome to Amazing Numbers!%n%n");

        System.out.printf(
                "Supported requests:%n"+
                        "- enter a natural number to know its properties;%n"+
                        "- enter 0 to exit.%n%n"
        );
        boolean even = false;
        boolean odd = false;
        boolean buzz = false;
        boolean duck = false;
        boolean palindromic = false;
        long num = 1;

        do {
            even = false;
            odd = false;
            buzz = false;
            duck = false;
            palindromic = false;
            System.out.println("Enter a request: > ");
            num = scanner.nextLong();


            if (num % 1 != 0 || num < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (num == 0) {
                break;
            } else {
                if (num % 2 == 0) {
                    even = true;
                } else {
                    odd = true;
                }

                String numStr = String.valueOf(num);
                if (numStr.charAt(numStr.length() - 1) == '7' || num % 7 == 0) {
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

                char[] reverseArray = new char[numStr.length()];
                for (int i = 0; i <=  numStr.length() - 1; i++) {
                    reverseArray[i] = numStr.charAt(numStr.length() - i - 1);
                }
                String reverseStr = String.valueOf(reverseArray);

                long numReverse = Long.parseLong(reverseStr, 10);

                if (numReverse == num) {
                    palindromic = true;
                }

                System.out.printf("Properties of %d%n even: %b%n odd: %b%n buzz: %b%n duck: %b%n palindromic: %b%n", num, even, odd, buzz, duck, palindromic);
            }

        } while (num != 0);
        System.out.println("Goodbye!");
    }
}
