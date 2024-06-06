class Solution {
    public int maximumCount(int[] nums) {
        int s = 0;
        int count = 0;
        int countP = 0;
        int countN = 0;
        while(s < nums.length){
            if(nums[s] < 0){
                countN++;
            }else if(nums[s] > 0){
                countP++;
            }
            s++;
        }
        if(countN < countP ){
            count = countP;
        }else if(countN > countP){
            count = countN;
        }else{
            count = countP = countN;
        }
        return count;
    }
}