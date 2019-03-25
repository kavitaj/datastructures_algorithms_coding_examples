package com.math.examples;

public class Fibonacci {
     //Dynamic Programming Bottom Up Approach
     //We start solving the problem with the smallest possible inputs and store it for future.
     //Now as we calculate for the bigger values use the stored solutions (solution for smaller problems).
        public int fibDP(int x) {
            int[] fib = new int[x + 1];
            fib[0] = 0;
            fib[1] = 1;

            for (int i = 2; i < x + 1; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }

        return fib[x];
    }
}
