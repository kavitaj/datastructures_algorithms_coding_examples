package com.algorithms.dynamicProgramming;

public class SubsetSumDP {

    /*
    Base Cases:

If no elements in the set then we can’t make any subset except for 0.
If sum needed is 0 then by returning the empty subset we can make the subset with sum 0.

Given – Set = arrA[], Size = n, sum = S

Now for every element in he set we have 2 options, either we include it or exclude it.
for any ith element-
If include it => S = S-arrA[i], n=n-1
If exclude it => S, n=n-1.
Recursive Equation:
Base Cases:
SubsetSumDynamic(arrA, n, S)= false, if sum > 0 and n == 0 SubsetSumDynamic(arrA, n, S)= true, if sum == 0 (return empty set)
Rest Cases
SubsetSumDynamic(arrA, n, S) = SubsetSumDynamic(arrA, n-1, S)|| SubsetSumDynamic(arrA, n-1, S-arrA[n-1])
     */
    public static boolean subSetDP(int[] A, int sum) {
        boolean[][] solution = new boolean[A.length + 1][sum + 1];
        // if sum is not zero and subset is 0, we can't make it
        for(int i=1;i<=sum;i++){
            solution[0][i]=false;
        }
        // if sum is 0 the we can make the empty subset to make sum 0
        for(int i=0;i<=A.length;i++){
            solution[i][0]=true;
        }
        //
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=sum;j++){
                //first copy the data from the top
                solution[i][j] = solution[i-1][j];

                //If solution[i][j]==false check if can be made
                if(!solution[i][j] && j>=A[i-1])
                    solution[i][j] = solution[i][j] || solution[i-1][j-A[i-1]];
            }
        }
        return solution[A.length][sum];
    }



    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (S > sum || -S < -sum || (S + sum) % 2 == 1) return 0;

        int[] dp = new int[(S + sum) / 2 + 1];
        dp[0] = 1;

        for (int num: nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] += dp[i - num]; // Crux
            }
        }

        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        int[] A = { 3, 2, 7, 1,8, 6};
        System.out.println("\nFrom DP: " + subSetDP(A, 6) );
        System.out.println("\nFrom DP: " + findTargetSumWays(A, 9) );
        System.out.println("\nFrom DP: " + findTargetSumWays(A, 10) );
    }
}