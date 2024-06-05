class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(Integer num : nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }
    
    public static boolean even(int num){
        int nums = digit(num);
        return nums % 2 == 0;
    }
    
    // public static int digit(int num){
    //     int count = 0;
    //     while(num > 0){
    //         count++;
    //         num = num / 2;
    //     }
    //     return count;
    // }
    
    public static int digit(int num){
        if(num < 0){
            num = num * -1;
        }
        return (int)(Math.log10(num)) + 1;
    }
}