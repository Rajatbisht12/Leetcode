class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index >= 0) {
            return index; // Target found, return its index
        } else {
            // Not found, insert at -(index + 1) (adjusted for negative insertion point)
            return -(index + 1);
        }
    }
}
