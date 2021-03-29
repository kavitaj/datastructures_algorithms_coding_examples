package com.algorithms.divideAndConquer;

/* Divide and conquer is an algorithmic paradigm in which the problem is
   repeatedly divided into subproblems until we reach a point
   where each problem is similar and atomic, i.e., can’t be further divided.
   At this point, we start solving these atomic problems and combining (merging) the solutions together.
   Therefore, divide and conquer solutions have the following three steps:
   Divide
   Conquer
   MergeSortedArrays
   If we start in the middle of the array, either we are lucky and the element matches
   or we discard half of the array.
   In the worst case, we repeatedly discard half of the sub-arrays from the previous step
   until the array can no longer be subdivided, i.e., it is of size 1.
   An array of size n can be divided into halves log(n) times until we reach a subarray of size 1.
   Hence, the time complexity of finding an element in a sorted array using this technique is O(log n)
 */

public class BinarySearch {
 
 public static int BinarySearch(int arr[], int left, int right, int key) {
  
  if (right >= left) {
   
   int MidElement = left + (right - left) / 2;
   if (arr[MidElement] == key) // If the required element is found at the middle index
    return MidElement;

   if (key < arr[MidElement]) // If the required element is smaller than the element at the middle index  It can only be present in the left subarray 
    return BinarySearch(arr, left, MidElement - 1, key);

   return BinarySearch(arr, MidElement + 1, right, key); // else, it would be present in the right subarray  
  }
  return -1; // Element not found, and the array can not be further divided.  
 }



 //the implementation of the algorithm from the java.util.Arrays class for an int array source:

 private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
  int low = fromIndex;
  int high = toIndex - 1;

  while (low <= high) {
   int mid = (low + high) >>> 1; //What does the “>>> 1” do? That’s basically a divide by two operations.
   int midVal = a[mid];

   if (midVal < key)
    low = mid + 1;
   else if (midVal > key)
    high = mid - 1;
   else
    return mid; // key found
  }
  //return -1;
  return -(low + 1);  // key not found.
  //The return value of “-(low +1)” gives the caller the insert position
  // where to insert the new key, if they wanted to do that task.
 }

public static void main(String args[]) {
 
 int arr[] = { 3, 5, 7, 15, 25 }; 

 int key = 7; // to find, feel free to change this
 int result = binarySearch0(arr, 0, arr.length - 1, key);

 if (result != -1)
  System.out.println("Key " + "\"" + key + "\" found at index = " + result);
 else
  System.out.println("Key " + "\"" + key + "\"not found!");

 key = 10; // Trying for a different value
 result = binarySearch0(arr, 0, arr.length - 1, key);

 if (result >= 0)
  System.out.println("Key " + "\"" + key + "\" found at index = " + result);
 else
  System.out.println("Key " + "\"" + key + "\" not found! Insert Position: "+Math.abs(result));

}
}