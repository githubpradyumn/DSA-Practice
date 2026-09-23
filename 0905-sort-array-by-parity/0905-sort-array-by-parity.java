class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=0,j=0;
        int n = nums.length;
        while(j<n){
            if(nums[i]%2==0 && nums[j]%2==0){
                i++;
                j++;
            } else if (nums[j]%2!=0 && nums[i]%2!=0) {
                j++;
            } else if(nums[j]%2==0 && nums[i]%2!=0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
        }
        return nums;
    }
}