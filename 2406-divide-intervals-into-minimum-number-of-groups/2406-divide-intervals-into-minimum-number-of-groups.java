import java.util.Arrays;

class Solution {
    public int minGroups(int[][] intervals) {
        // Create two arrays for start and end times
        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        // Fill the arrays with start and end times
        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        // Sort both arrays
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int count = 0, endIndex = 0;
        
        // Use two pointers to count the maximum number of overlapping intervals
        for (int startIndex = 0; startIndex < n; startIndex++) {
            // If the current start time is less than or equal to the end time
            if (startTimes[startIndex] <= endTimes[endIndex]) {
                count++; // Increase count for a new group
            } else {
                endIndex++; // Move the end pointer to the next ending interval
            }
        }
        
        return count;
    }
}
