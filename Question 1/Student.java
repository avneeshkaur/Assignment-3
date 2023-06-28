import java.util.Arrays;

public class Student {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array in ascending order
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize the closest sum

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Pointer for the element on the left
            int right = nums.length - 1; // Pointer for the element on the right

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right]; // Calculate the current sum

                if (currentSum == target) {
                    return currentSum; // Found the target sum, return it
                }

                // Update the closest sum if the current sum is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Adjust the pointers based on the current sum
                if (currentSum < target) {
                    left++; // Move the left pointer to increase the sum
                } else {
                    right--; // Move the right pointer to decrease the sum
                }
            }
        }

        return closestSum; // Return the closest sum found
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int result = threeSumClosest(nums, target);
        System.out.println(result);
    }
}
