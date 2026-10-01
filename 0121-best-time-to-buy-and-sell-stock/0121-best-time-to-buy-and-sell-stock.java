class Solution {
    public int maxProfit(int[] nums) {
        int a = 0;
        int profit = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[a]<nums[i]){
                if(profit<nums[i]-nums[a]){
                    profit = nums[i]-nums[a];
                }
            } else if(nums[a]>nums[i]){
                a = i;
            }
        }
        return profit;
    }
}