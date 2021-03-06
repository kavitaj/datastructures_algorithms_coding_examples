package com.datastructures.arrays;

public class FindSecondMinimum {

    // Find max value in an unsorted array of ints.
    public static int findMin (int [] A, int startIndex) {
        if (startIndex == A.length - 1) {
            return A[startIndex];
        } else {
            return Math.min(A[startIndex],
                    findMin(A, startIndex + 1));
        }
    }

    public static int getMinIndex(int[] values) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0; i<values.length; i++)
            if (values[i] < minValue) {
                minValue = values[i];
                minIndex = i;
            }
        return minIndex;
    }

    public static int getSecondMinIndex(int[] values) {
        int secondIdx = -1;
        int minIdx= getMinIndex(values);
        for(int i=0; i<values.length; i++) {
            if (i == minIdx) continue;
            if (secondIdx == -1 || values[i] < values[secondIdx])
                secondIdx = i;
        }
        return secondIdx;
    }
}
