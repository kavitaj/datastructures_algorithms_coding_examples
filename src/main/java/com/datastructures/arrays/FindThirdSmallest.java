package com.datastructures.arrays;

// Java program to find the first, second
// and third minimum element in an array

/*
First approach : First we can use normal method that is
sort the array and then print first, second and third element of the array.
Time complexity of this solution is O(n Log n).

Second approach : Time complexity of this solution is O(n).
Algorithm-

First take an element
then if array[index] < Firstelement
        Thirdelement = Secondelement
        Secondelement = Firstelement
        Firstelement = array[index]
     else if array[index] < Secondelement
        Thirdelement = Secondelement
        Secondelement = array[index]
     else if array[index] < Thirdelement
        Thirdelement = array[index]

then print all the element
 */


import java.util.Arrays;

public class FindThirdSmallest
{
    static void Print3Smallest(int array[], int n)
    {
            int firstmin = Integer.MAX_VALUE;
            int secmin = Integer.MAX_VALUE;
            int thirdmin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++)
            {
                /* Check if current element is less than
                firstmin, then update first, second and
                third */
                if (array[i] < firstmin)
                {
                    thirdmin = secmin;
                    secmin = firstmin;
                    firstmin = array[i];
                }
          
                /* Check if current element is less than
                secmin then update second and third */
                else if (array[i] < secmin)
                {
                    thirdmin = secmin;
                    secmin = array[i];
                }
          
                /* Check if current element is less than
                then update third */
                else if (array[i] < thirdmin)
                    thirdmin = array[i];
            }

            System.out.println("First min = " + firstmin );
            System.out.println("Second min = " + secmin );
            System.out.println("Third min = " + thirdmin );
    }

    // Driver code
    public static void main(String[] args)
    {
            int array[] = {4, 67, 1, 32, 12, 29, 65, 6, 7, 34};
            int n = array.length;
            Print3Smallest(array, n);

        System.out.println("Nth Smallest = " + NthSmallest(array, 4));
    }


    public static int NthSmallest(int[] arr, int n) {
        int start = 0;
        int end = arr.length - 2;
        int index = 0;
        int[] newArray = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[index]) {
                newArray[start] = arr[i];
                start++;
            } else {
                newArray[end] = arr[i];
                end--;
            }
        }
        System.out.println(Arrays.toString(newArray));
        if (n > start) {
            return NthSmallest(Arrays.copyOfRange(newArray, start + 1, newArray.length), n - start);
        } else if (n < start) {
            return NthSmallest(Arrays.copyOfRange(newArray, 0, start), n);
        } else {
            return arr[start];
        }
    }


    }
      


  
