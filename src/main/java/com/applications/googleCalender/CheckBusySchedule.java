package com.applications.googleCalender;

import java.util.Arrays;
import java.util.ArrayList; 

/*
we want to find the times during which a user is busy.
This feature is intended to show the busy hours of a user to other users
without revealing the individual meeting slots.
Therefore, if any meetings overlap or are back to back, then we want to merge their timings.
 */

//Time complexity #
//The time complexity is O(n×log(n)), where n is the number of meetings in the schedule.
// The sorting takes up O(n×log(n)) time,
// whereas the rest of the algorithm is O(n).
// Since O(n×log(n)) dominates, it will be the final complexity of the solution.

//Space complexity #
//The space complexity is O(1), as constant memory is allocated.
// However, if sorting is not in-place, the space complexity would be O(n).

class CheckBusySchedule {
    public static int[][] mergeMeetings(int[][] meetingTimes){
        Arrays.sort(meetingTimes, (a, b) -> Integer.compare(a[0], b[0])); 
        
        ArrayList<int[]> merged = new ArrayList<>();
        for (int[] meeting: meetingTimes){
            int size = merged.size();
            if(size == 0 || merged.get(size - 1)[1] < meeting[0]){
                merged.add(meeting);
            }
            else{
                merged.get(size - 1)[1] = Math.max(merged.get(size - 1)[1], meeting[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main( String args[] ) {
        int[][] meetingTimes1 = {{1, 4}, {2, 5}, {6, 8}, {7, 9}, {10, 13}};
        System.out.println(Arrays.deepToString(mergeMeetings(meetingTimes1)));
        int[][] meetingTimes2 = {{4, 7}, {1, 3}, {8, 10}, {2, 3}, {6, 8}};
        System.out.println(Arrays.deepToString(mergeMeetings(meetingTimes2)));
    }
}

/*
To solve this problem, it is best to sort the meetings based on the startTime.
Then, we can determine if two meetings should be merged or not by processing them simultaneously.

Here is how we’ll implement this feature:

First, we will sort the meetings according to startTime.
Considering two meetings at a time,
we will then check if the startTime of the second meeting is less than the endTime of the first meeting.
If the condition is true, merge the meetings into a new meeting and delete the existing ones.
Repeat the above steps until all the meetings are processed.

 */