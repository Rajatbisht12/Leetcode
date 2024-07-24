class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, area = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            area = Math.min(height[l], height[r]) * (r - l);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--; // This line was incorrect in the original code
            }
            maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
    }
}