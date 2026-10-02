class Solution {
    public int[] runningSum(int[] nums) {
        // int[] answer = new int[nums.length];
        // answer[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i]+nums[i-1];
        }
        return nums;
    }
}