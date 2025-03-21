class Solution {
    public int missingNumber(int[] nums) {
        int actual_sum = 0;
        int n = nums.length;
        int sum = n*(n+1)/2;
        for(int i = 0; i < n; i++){
            actual_sum += nums[i];
        }
        int missing_num = sum - actual_sum;
        return missing_num;
    }
}