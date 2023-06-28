import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quadruplets {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Sort the array in ascending order
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1; // Left pointer
                int right = n - 1; // Right pointer

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // Found a quadruplet, add it to the result
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;

                        // Move the pointers
                        left++;
                        right--;
                    } else if (sum < target) {
                        // Sum is smaller than target, move the left pointer
                        left++;
                    } else {
                        // Sum is greater than target, move the right pointer
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        System.out.println(result);
    }
}
