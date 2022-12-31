/*
 * Copyright (c) 2022 Beaudelaire Tsoungui Nzodoumkouo. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under My consent.
 *
 * This code is shared on GitHub in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Please contact Me at +1 438 509 3906
 * or LinkedIn: https://www.linkedin.com/in/beaudelaire-tsoungui-nzodoumkouo-809744231
 * if you need additional information or have any questions.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * A class that contains methods for processing user input and performing actions based on that input.
 */
public class Actions {
    private final String[] save = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD",
            "-EVEN", "-ODD", "-BUZZ", "-DUCK", "-PALINDROMIC", "-GAPFUL", "-SPY", "-SQUARE", "-SUNNY", "-JUMPING", "-HAPPY", "-SAD"};

    private final ArrayList<String> properties = new ArrayList<>(List.of(save));

    /**
     * Processes input from the user and performs the appropriate action.
     *
     * @throws NumberFormatException if the first entry is not a valid natural number or zero
     */
    public void processInput(){
        while (true) {
            try {
                // get the input from the user
                String[] inputs = getInput();

                int entries = inputs.length;

                // process the input based on the number of entries
                switch (entries){
                    case 1 -> oneEntry(inputs);
                    case 2 -> twoEntries(inputs);
                    default -> threeAndMoreEntries(inputs);
                }

            } catch (NumberFormatException e) {
                System.out.println("\nThe first and second parameter should be a natural number or zero.");
            }
        }
    }

    /**
     * Prompts the user for input and returns the input as an array of strings.
     *
     * @return the user's input as an array of strings
     */
    private String[] getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a request: ");
        String scan = sc.nextLine();
        return scan.split(" ");
    }

    /**
     * Prints a message describing the supported actions that can be performed.
     */
    public void printActions(){
        System.out.print("""
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be printed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
                - separate the parameters with one space;
                - enter 0 to exit.
                """);
    }

    /**
     * Returns a list of the properties of the given Number object.
     *
     * @param num the Number object to check for properties
     * @return a list of the properties of the given Number object
     */
    private  ArrayList<String> validFor ( Number num){
        ArrayList<String> list = new ArrayList<>();
        if (num.isBuzz()) list.add("buzz");
        if (num.isDuck()) list.add("duck");
        if (num.isPalindromic()) list.add("palindromic");
        if (num.isGapful()) list.add("gapful");
        if (num.isSpy()) list.add("spy");
        if (num.isSquare()) list.add("square");
        if (num.isSunny()) list.add("sunny");
        if (num.isJumping()) list.add("jumping");
        if (num.isEven()) list.add("even");
        if (!num.isEven()) list.add("odd");
        if (num.isHappy()) list.add("happy");
        if (!num.isHappy()) list.add("sad");
        return list;
    }

    /**
     * Converts a list of strings to a single string by concatenating the strings with a comma and space between them.
     * It is used to format our output.
     * @param list the list of strings to be concatenated
     * @return the concatenated string
     */
    private String print (ArrayList < String > list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                builder.append(list.get(i)).append(", ");
            } else {
                builder.append(list.get(i));
            }
        }
        return builder.toString();
    }

    /**
     * Determines if all elements in a boolean array are true.
     *
     * @param test the array of booleans to be checked
     * @return true if all elements in the array are true, false otherwise
     */
    private boolean checkTruth ( boolean[] test){
        boolean truth = false;
        for (boolean currentTruth : test) {
            if (!currentTruth) {
                truth = false;
                break;
            } else truth = true;
        }
        return truth;
    }

    /**
     * Prints a range of numbers and their properties based on the specified input properties.
     *
     * @param inputProperties the properties to search for in the range of numbers
     * @param values an array of booleans used to store the results of the property checks
     * @param start the starting number of the range
     * @param numInterations the number of iterations to perform
     */
    private void printRange(ArrayList<String> inputProperties, boolean[] values, Number start, int numInterations) {
        int count = 0;  // counter for the number of iterations
        do {
            // set the value of each element in the values array based on the properties of the start number
            for (int i = 0; i < inputProperties.size(); i++) {

                switch (inputProperties.get(i)) {
                    case "EVEN", "-ODD" -> values[i] = (start.isEven());
                    case "ODD", "-EVEN" -> values[i] = (!start.isEven());
                    case "BUZZ" -> values[i] = (start.isBuzz());
                    case "DUCK" -> values[i] = (start.isDuck());
                    case "PALINDROMIC" -> values[i] = (start.isPalindromic());
                    case "GAPFUL" -> values[i] = (start.isGapful());
                    case "SPY" -> values[i] = (start.isSpy());
                    case "SQUARE" -> values[i] = (start.isSquare());
                    case "SUNNY" -> values[i] = (start.isSunny());
                    case "JUMPING" -> values[i] = (start.isJumping());
                    case "HAPPY", "-SAD" -> values[i] = (start.isHappy());
                    case "SAD", "-HAPPY" -> values[i] = (!start.isHappy());

                    case "-BUZZ" -> values[i] = (!start.isBuzz());
                    case "-DUCK" -> values[i] = (!start.isDuck());
                    case "-PALINDROMIC" -> values[i] = (!start.isPalindromic());
                    case "-GAPFUL" -> values[i] = (!start.isGapful());
                    case "-SPY" -> values[i] = (!start.isSpy());
                    case "-SQUARE" -> values[i] = (!start.isSquare());
                    case "-SUNNY" -> values[i] = (!start.isSunny());
                    case "-JUMPING" -> values[i] = (!start.isJumping());
                }
            }
            // print the value of start and its
            // properties if all elements in the values array are true
            if (checkTruth(values)) {
                System.out.println("\t\t" + String.format("%,d", start.getNumber()) + " is " + print(validFor(start)));
                count++;
            }
            // increment the start number
            start.increment();
        } while (count != numInterations) ; // continue iterating until the number of iterations equals numInterations
    }

    /**
     * Determines if two properties are mutually exclusive.
     *
     * @param property1 the first property to be checked
     * @param property2 the second property to be checked
     * @return an array containing the two properties if they are mutually exclusive,
     *         null if they are not mutually exclusive
     */
    private String[] areMutuallyExclusive(String property1, String property2) {
        String[] result = null;// will store the result of the search

        // array of pairs of properties that are mutually exclusive
        String[][] mutuallyExclusivePairs = {{"EVEN", "ODD"}, {"DUCK", "SPY"}, {"SUNNY", "SQUARE"}, {"HAPPY", "SAD"},
                {"-EVEN", "-ODD"}, {"-HAPPY", "-SAD"}, {"EVEN", "-EVEN"}, {"ODD", "-ODD"},
                {"DUCK", "-DUCK"}, {"SPY", "-SPY"}, {"SUNNY", "-SUNNY"}, {"SQUARE", "-SQUARE"}, {"HAPPY", "-HAPPY"},
                {"SAD", "-SAD"}, {"BUZZ", "-BUZZ"}, {"PALINDROMIC", "-PALINDROMIC"}, {"GAPFUL", "-GAPFUL"}, {"JUMPING", "-JUMPING"},};

        // search for a mutually exclusive pair that includes property1 and property2
        for (String[] mutuallyExclusivePair : mutuallyExclusivePairs) {
            if ((mutuallyExclusivePair[0].equals(property1) && mutuallyExclusivePair[1].equals(property2))
                    || (mutuallyExclusivePair[0].equals(property2) && mutuallyExclusivePair[1].equals(property1))) {
                result = mutuallyExclusivePair.clone();
                break;
            }
        }
        return result;
    }

    /**
     * Processes input with one entry.
     *
     * @param array an array containing the input from the user
     */
    private void oneEntry(String[] array){

        long input = Long.parseLong(array[0]);
        if (input > 0) {
            Number in = new Number(input);
            System.out.println("\nProperties of " + String.format("%,d", input) + "\n" +
                    "        buzz: " + in.isBuzz() + "\n" +
                    "        duck: " + in.isDuck() + "\n" +
                    " palindromic: " + in.isPalindromic() + "\n" +
                    "      gapful: " + in.isGapful() + "\n" +
                    "         spy: " + in.isSpy() + "\n" +
                    "      square: " + in.isSquare() + "\n" +
                    "       sunny: " + in.isSunny() + "\n" +
                    "     jumping: " + in.isJumping() + "\n" +
                    "       happy: " + in.isHappy() + "\n" +
                    "         sad: " + !in.isHappy() + "\n" +
                    "        even: " + in.isEven() + "\n" +
                    "         odd: " + !in.isEven());
        } else if (input == 0) {
            System.out.println("\nGoodbye!");
            System.exit(0);
        } else {
            System.out.println("\nThe first parameter should be a natural number or zero.");
        }
    }

    /**
     * Processes input with two entries.
     *
     * @param array an array containing the input from the user
     * @throws NumberFormatException if the first entry is not a valid natural number or zero,
     * or if the second entry is not a valid natural number
     */
    private void twoEntries(String[] array){
        long Start = Long.parseLong(array[0]);
        long End = Start + Long.parseLong(array[1]);
        System.out.println();

        if (Start < 0 || Long.parseLong(array[1]) <= 0) {
            System.out.println((Start <= 0) ? "The first parameter should be a natural number or zero."
                    : "The second parameter should be a natural number.");
        } else {
            for (long i = Start; i < End; i++) {
                System.out.println("\t\t" + String.format("%,d", i) + " is " + print(validFor(new Number(i))));
            }
        }
    }

    /**
     * Processes input with three or more entries.
     *
     * @param array an array containing the input from the user
     * @throws NumberFormatException if the first entry is not a valid natural number or zero,
     * or if the second entry is not a valid natural number
     */
    private void threeAndMoreEntries(String[] array){
        ArrayList<String> inputProperties = new ArrayList<>(Arrays.asList(array).subList(2, array.length));
        inputProperties.replaceAll(String::toUpperCase);

        boolean[] values = new boolean[inputProperties.size()];

        ArrayList<String> doesNotExist = new ArrayList<>();

        for (String targetProperty : inputProperties) {
            if (!properties.contains(targetProperty)) doesNotExist.add(targetProperty);
        }

        ArrayList<String> mutuallyExcluded = new ArrayList<>();
        for (int i = 0; i < inputProperties.size(); i++) {
            for (int j = (i + 1); j < inputProperties.size(); j++) {
                if (areMutuallyExclusive(inputProperties.get(i), inputProperties.get(j)) != null) {
                    mutuallyExcluded.add(areMutuallyExclusive(inputProperties.get(i), inputProperties.get(j))[0]);
                    mutuallyExcluded.add(areMutuallyExclusive(inputProperties.get(i), inputProperties.get(j))[1]);
                }
            }
        }

        if (mutuallyExcluded.size() >= 1) {

            System.out.println("\nThe request contains mutually exclusive properties: " + mutuallyExcluded +
                    "\nThere are no numbers with these properties.");

        } else if (doesNotExist.size() >= 1) {
            System.out.println((doesNotExist.size() == 1) ? "\nThe property " + doesNotExist + " is wrong."
                    : "\nThe properties " + doesNotExist + " are wrong.");
            System.out.println("Available properties: " + properties);
        } else {
            System.out.println();
            printRange(inputProperties, values, new Number(array[0]), Integer.parseInt(array[1]));
        }

    }
}