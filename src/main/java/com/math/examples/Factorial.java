package com.math.examples;

public class Factorial {

    public static int getFactorial(int n) {
        int i, val = 1;
        for (i = n; i > 1; i--)  /* n = 0 or 1 falls through */ {
            val *= i;
        }
        return val;
    }


    public static void main(String[] args) {
        System.out.println("Factorial of 25: " + getFactorial(25));
    }
}

