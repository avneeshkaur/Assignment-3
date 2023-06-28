import java.util.ArrayList;
import java.util.List;

public class Missing {
    public static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> missingRanges = new ArrayList<>();
        
        int next = lower;
        for (int num : nums) {
            if (num > next) {
                missingRanges.add(createRange(next, num - 1));
            }
            next = num + 1;
        }
        
        if (next <= upper) {
            missingRanges.add(createRange(next, upper));
        }
        
        return missingRanges;
    }
    
    private static List<Integer> createRange(int start, int end) {
        List<Integer> range = new ArrayList<>();
        range.add(start);
        range.add(end);
        return range;
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        
        List<List<Integer>> missingRanges = findMissingRanges(nums, lower, upper);
        for (List<Integer> range : missingRanges) {
            System.out.println(range);
        }
    }
}
