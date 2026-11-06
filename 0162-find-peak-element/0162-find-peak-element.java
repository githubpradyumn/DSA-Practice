class Solution {
    public int findPeakElement(int[] nums) {
        int peek = nums[nums.length-1];
        int idx = nums.length-2;
        int ans = idx+1;
        while(idx>=0){
            if(nums[idx]>=peek){
                peek = nums[idx];
                ans = idx;
            }
            idx--;
        }
        return ans;
    }
}