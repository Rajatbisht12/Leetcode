class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int [] arr : grid){
            for(int ele : arr){
                if(ele < 0){
                    count++;
                }
            }
        }
        return count;
    }
}