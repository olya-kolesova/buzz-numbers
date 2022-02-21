package com.company;

import java.util.ArrayList;

public class Classifier {

    private boolean even;
    private boolean odd;
    private boolean buzz;
    private boolean duck;
    private boolean palindromic;
    private boolean gapful;
    private Long number;
    private Long num2;

    Classifier() {
        this.even = false;
        this.odd = false;
        this.buzz = false;
        this.duck = false;
        this.palindromic = false;
        this.gapful = false;
        this.number = number;
        this.num2 = num2;
    }

    public ArrayList<String[]> classify(long num) {
        this.even = false;
        this.odd = false;
        this.buzz = false;
        this.duck = false;
        this.palindromic = false;
        this.gapful = false;
        this.number = number;
        this.num2 = num2;

        if (num % 1 != 0 || num < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
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
            for (int i = 0; i <= numStr.length() - 1; i++) {
                reverseArray[i] = numStr.charAt(numStr.length() - i - 1);
            }
            String reverseStr = String.valueOf(reverseArray);

            long numReverse = Long.parseLong(reverseStr, 10);

            if (numReverse == num) {
                palindromic = true;
            }
        }

        ArrayList<String[]> properties = new ArrayList<> ();
        properties.add(new String[]{"even", String.valueOf(even)});
        properties.add(new String[]{"odd", String.valueOf(odd)});
        properties.add(new String[]{"buzz", String.valueOf(buzz)});
        properties.add(new String[]{"duck", String.valueOf(duck)});
        properties.add(new String[]{"palindromic", String.valueOf(palindromic)});
//        properties.set(0, new String[]{"gapful", String.valueOf(gapful)});
        return properties;
    }
}
