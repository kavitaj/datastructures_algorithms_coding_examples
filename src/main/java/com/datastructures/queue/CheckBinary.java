package com.datastructures.queue;

class CheckBinary {
//Can you generate binary numbers from 1 to any given number "n"?
    /*
    The crux of the solution is to generate consecutive binary numbers
    from previous binary numbers by appending 0 and 1 to each of them.
     For example,
    10 and 11 can be generated when 0 and 1 are appended to 1.
    100 and 101 are generated when 0 and 1 are appended to 10.
    As soon as a binary number is generated, it is enqueued to a queue
    so that new binary numbers can be generated by appending 0 and 1 when that number will be dequeued.
    As the queue follows the First-In, First-Out property, the enqueued binary numbers are dequeued
    in an order such that the overall resultant array is mathematically correct.

    Let’s get to the code now. On line 11, 1 is enqueued as a starting point.
     Now, to generate the binary number sequence,
      a number is dequeued from the queue and stored in the result array.
      0 and 1 are appended to it to produce the next numbers which are
      then also enqueued to the queue.
      The queue takes integer values, so before enqueueing,
       the solution makes sure to convert the string to an integer.
       The size of the queue should be one more than number because,
        for a single number, we’re enqueuing two variations of it,
        one with appended 0, while other with 1 being appended.

    Time Complexity #
    The time complexity of this solution is in O(n) as the array is iterated over once.
     */

    //1.Start with Enqueuing 1.
    //2.Dequeue a number from queue and append 0 to it and enqueue it back to queue.
    //3.Perform step 2 but with appending 1 to the original number and enqueue back to queue.
    //Size of Queue should be 1 more than number because for a single number we're enqueuing two
    public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new Queue<String>(number + 1);

        queue.enqueue("1");

        for (int i = 0; i < number; i++) {
            result[i] = queue.dequeue();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            System.out.print("s1="+s2+ ",s2="+s1+", result["+(i+1)+"]="+result[i]);
            System.out.println();
            queue.enqueue(s1);
            queue.enqueue(s2);
        }

        return result; //For number = 3 , result = {"1","10","11"};
    }
  
    public static void main(String args[]) {

        String[] output = findBin(30);
        for(int i = 0; i < 30; i++)
            System.out.print(output[i] + " ");
    }

}


class Queue<V> {
    private int maxSize;
    private V[] array;
    private int front;
    private int back;
    private int currentSize;

    /*
    Java does not allow generic type arrays. So we have used an
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Comment out the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        array = (V[]) new Object[maxSize];
        front = 0;
        back = -1;
        currentSize = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public V top() {
        return array[front];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void enqueue(V value) {
        if (isFull())
            return;
        back = (back + 1) % maxSize; //to keep the index in range
        array[back] = value;
        currentSize++;
    }

    public V dequeue() {
        if (isEmpty())
            return null;

        V temp = array[front];
        front = (front + 1) % maxSize; //to keep the index in range
        currentSize--;

        return temp;
    }
}