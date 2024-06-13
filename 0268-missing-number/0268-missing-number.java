class Solution {
    public int missingNumber(int[] arr){
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else{
                i += 1;
            }
        }
        
        // Case 1
        for(int j= 0; j< arr.length; j++){
            if(arr[j] != j){
                return j;
            }
        }
        // Case 2
        return arr.length;
    }
    static void swap(int [] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}