class Solution {
    public int max(int[] nums){
        int max = nums[0];
        for(int num: nums){
            if(max<num){
                max = num;
            }
        }
        return max;
    }
    public long countSubarrays(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int count = 0;
        long length = 0;
        int max = max(nums);
        while(right<nums.length){
            if(nums[right]==max){
                count++;
            }
            while(count==k){
                if(nums[left]==max){
                    count--;
                }
                left++;
            }
            length = left+length;
            right++;
        }
        return length;
    }
}