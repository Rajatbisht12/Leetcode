class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int [] arr : accounts){
            int rowSum = 0;
            for(int val : arr){
                rowSum = rowSum + val;
            }
            if(rowSum > max){
                max = rowSum;
            }
        }
        return max;
    }
}