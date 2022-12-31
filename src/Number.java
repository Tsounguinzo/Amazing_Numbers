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

/**
 * The {@code Number} class wraps a value of the primitive type
 * {@code long} in an object. An object of type {@code Number}
 * contains a single field whose type is {@code long}.
 *
 * <p>In addition, this class provides a method for converting
 * a {@code long} to a {@code String} and a {@code String} to a
 * {@code long}, as well as other methods useful when
 * dealing with a certain properties of numbers.
 *
 * @author Beaudelaire Tsoungui Nzodoumkouo
 */
public class Number {
    private long number;

    /**
     * Constructs a new Number object with the given long value.
     *
     * @param number the long value to set as the number
     */
    public Number(long number){
        this.number = number;
    }

    /**
     * Constructs a new Number object with the given String value.
     *
     * @param number the String representation of the number
     */
    public Number(String number){
        this.number = Long.parseLong(number);
    }

    /**
     * Returns the long value of the Number object.
     *
     * @return the long value of the Number object
     */
    public long getNumber() {
        return this.number;
    }

    /**
     * Increments the long value of the Number object by 1.
     */
    public void increment(){
        this.number += 1;
    }

    /**
     * Returns whether the long value of the Number object is a perfect square.
     *
     * @return true if the long value is a perfect square, false otherwise
     */
    public  boolean isSquare() {
        return Math.sqrt(getNumber()) % 1 == 0;
    }

    /**
     * Returns whether the long value of the Number object plus 1 is a perfect square.
     *
     * @return true if the long value plus 1 is a perfect square, false otherwise
     */
    public boolean isSunny (){
        return Math.sqrt(getNumber() + 1) % 1 == 0;
    }

    /**
     * Returns whether the long value of the Number object is a spy number.
     *
     * A spy number is a number whose sum and product of its digits are equal.
     *
     * @return true if the long value is a spy number, false otherwise
     */
    public  boolean isSpy (){
        long num = getNumber();
        long digitSum = 0;
        long digitProduct = 1;
        while (num > 0) {
            digitSum += lastDigit(num);
            digitProduct *= lastDigit(num);
            num /= 10;
        }
        return digitProduct == digitSum;
    }

    /**
     * Returns whether the long value of the Number object is even.
     *
     * @return true if the long value is even, false otherwise
     */
    public boolean isEven (){
        return getNumber() % 2 == 0;
    }

    /**
     * Returns whether the long value of the Number object is a multiple of 7 or ends in 7.
     *
     * @return true if the long value is a multiple of 7 or ends in 7, false otherwise
     */
    public boolean isBuzz (){
        return getNumber() % 7 == 0 || lastDigit(getNumber()) == 7;
    }

    /**
     * Returns whether the long value of the Number object is a palindrome.
     *
     * A palindrome is a number that is the same when read forwards and backwards.
     *
     * @return true if the long value is a palindrome, false otherwise
     */
    public boolean isPalindromic (){
        long num = getNumber();
        long reverse = 0;
        while (num > 0) {
            reverse *= 10;
            reverse += lastDigit(num);
            num /= 10;
        }

        return reverse == getNumber();
    }

    /**
     * Returns whether the long value of the Number object is a duck number.
     *
     * A duck number is a number that has a 0 in it, but the 0 is not the leading digit.
     *
     * @return true if the long value is a duck number, false otherwise
     */
    public boolean isDuck (){
        boolean test = false;
        String str = String.valueOf(getNumber());
        if (str.charAt(0) != '0') {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    test = true;
                    break;
                }
            }
        }
        return test;
    }

    /**
     * Returns the last two digits of the given long value.
     *
     * @param num the long value to extract the last two digits from
     * @return the last two digits of the given long value
     */
    private long lastTwoDigit ( long num){
        return (num > 99) ? num % 100 : num;
    }

    /**
     * Returns the last digit of the given long value.
     *
     * @param num the long value to extract the last digit from
     * @return the last digit of the given long value
     */
    private long lastDigit ( long num){
        return (num > 9) ? num % 10 : num;
    }

    /**
     * Returns whether the long value of the Number object is a gapful number.
     *
     * A gapful number is a number that is divisible by the number formed by concatenating
     * its first and last digits.
     *
     * @return true if the long value is a gapful number, false otherwise
     */
    public boolean isGapful (){
        String str = String.valueOf(getNumber());
        String concat = "" + str.charAt(0) + str.charAt(str.length() - 1);
        int arg = Integer.parseInt(concat);
        return getNumber() / 100 != 0 && getNumber() % arg == 0;
    }

    /**
     * Returns whether the long value of the Number object is a jumping number.
     *
     * A jumping number is a number whose digits are either increasing or decreasing in a sequential order.
     *
     * @return true if the long value is a jumping number, false otherwise
     */
    public boolean isJumping() {
        long last, bfLast, lastTwo;
        long num = getNumber();
        boolean result = true;
        while (num > 9) {
            lastTwo = lastTwoDigit(num);
            last = lastDigit(lastTwo);
            bfLast = lastTwo / 10;
            if ((last - bfLast) != 1 && (last - bfLast) != -1) {
                result = false;
                break;
            }
            num /= 10;
        }

        return result;
    }

    /**
     * Returns whether the long value of the Number object is a happy number.
     *
     * A happy number is a number that eventually becomes 1 when the sum of the squares of its digits
     * are repeatedly calculated.
     *
     * @return true if the long value is a happy number, false otherwise
     */
    public boolean isHappy() {
        long num1, num2;
        long num = getNumber();
        num = (num < 10) ? (num * num) : num;
        while (num / 10 != 0) {
            num2 = 0;
            while (num > 0) {
                num1 = (lastDigit(num) * lastDigit(num));
                num2 += num1;
                num /= 10;
            }
            num = num2;
        }
        return num == 1;
    }

    /**
     * Returns a String representation of the Number object.
     *
     * @return a String representation of the Number object
     */
    @Override
    public String toString() {
        return "" + this.number;
    }
}
