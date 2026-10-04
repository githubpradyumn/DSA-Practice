class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int count = 0;
        int length = 0;
        while(right<nums.length){
            if(nums[right]==0){
                count++;
            }
            while(count>k){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            length = Math.max(length,right-left+1);
            right++;
        }
        return length;
    }
}