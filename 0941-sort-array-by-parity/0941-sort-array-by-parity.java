class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        for (int i = 0 ; i < n ; i++){
            if(nums[i]%2!=0){
                for (int j = i + 1 ; j < n ; j++){
                    if (nums[j]%2==0){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }        
        }
        return nums;
    }
}