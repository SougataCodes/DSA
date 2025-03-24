class Solution {
    public int countDays(int days, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        int totalCovered = 0;        // Total days covered by meetings
        int start = meetings[0][0];  // Start of the current merged interval
        int end = meetings[0][1];    // End of the current merged interval
        
        // Process each meeting
        for (int i = 1; i < meetings.length; i++) {
            if (end >= meetings[i][0]) {
                // Overlap: extend the current interval
                end = Math.max(end, meetings[i][1]);
            } else {
                // No overlap: add the current interval's length to totalCovered
                totalCovered += end - start + 1;
                start = meetings[i][0];  // Start a new interval
                end = meetings[i][1];
            }
        }
        
        // Add the last merged interval
        totalCovered += end - start + 1;
        
        // Return the number of free days
        return days - totalCovered;
    }
}