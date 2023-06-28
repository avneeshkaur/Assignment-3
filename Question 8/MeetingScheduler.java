import java.util.Arrays;

public class MeetingScheduler {
    public static boolean canAttendAllMeetings(int[][] intervals) {
        // Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // Check for overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                // Found overlapping intervals
                return false;
            }
        }
        
        // No overlapping intervals found
        return true;
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        
        boolean canAttend = canAttendAllMeetings(intervals);
        System.out.println(canAttend);
    }
}
