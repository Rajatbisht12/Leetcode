class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            }else{
                i++;
            }
        }
        
        List<Integer> duplicates = new ArrayList<Integer>();
        for(int index = 0; index < nums.length; index++){ // Corrected the loop variable name
            if(nums[index] != index + 1){
                duplicates.add(nums[index]); // Changed 'missing' to 'duplicates'
            }
        }

        return duplicates;
    }
    
    public static void swap(int [] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
