import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        // Step 1: Cyclically sort the array
        for (int i = 0; i < n; i++) {
            int correctIndex = nums[i] - 1;
            while (nums[correctIndex] != nums[i]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
                correctIndex = temp - 1;
            }
        }

        // Step 2: Find the missing elements
        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                missing.add(i + 1);
            }
        }

        return missing;
    }
}