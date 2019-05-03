package com.datastructures.arrays;

import com.recursion.backtracking.SubSetSum;

public class MaxSubArray {

    //Given an array, the algorithm to find the maximum subarray sum is called Kadane’s Algorithm.
    //Let’s take an array dp[] where each dp[i] denotes maximum subarray sum ending at index i (including i).
    //And since we want the maximum subarray sum, we add the current element to the maximum of 0 and previous sum (zero here denotes that we’re starting anew from the current element).
    //This problem falls under Dynamic Programming Paradigm.
    //We can say that
     //dp[i]=max(dp(i-1),0)+arr[i]
    //Base conditions:
    // dp[0] = arr[0]
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public int getMaxSubarraySum(int[] array){
        int currentMax = 0;
        int totalMax =  Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            currentMax = Math.max(currentMax, 0) + array[i];
            totalMax = Math.max(totalMax, currentMax);
        }
        return totalMax;
    }


    //We could optimize the space complexity by taking dp[i-1]
    // which is the previous sum into a variable,
    // eliminating the need for dp[] array.
    //Time Complexity: O(N)
    //Space Complexity: O(1)

    public int getMaxSubarraySumOptimized(int[] array){
        int currentMax = Integer.MIN_VALUE;
        int totalMax =  Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            currentMax = Math.max(currentMax, 0) + array[i];
            totalMax = Math.max(totalMax, currentMax);
        }
        return totalMax;
    }


    public static void main(String[] args) {
        int[] input = { 2, 3, 4, -5, 7, -8,3, 2, 1, 6 };
        MaxSubArray maxSubArray = new MaxSubArray();
        int maxsum= maxSubArray.getMaxSubarraySumOptimized(input);
        System.out.println(maxsum);
    }
}
