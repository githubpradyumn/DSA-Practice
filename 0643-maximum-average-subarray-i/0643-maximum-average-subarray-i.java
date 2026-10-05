class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double answer =  Integer.MIN_VALUE;
        int right = 0;
        int left = 0;
        int sum = 0;
        while(right<nums.length){
            sum += nums[right];
            while((right-left)>k-1){
                sum -= nums[left];
                left++;
            }
            if(right-left+1==k){
                answer = Math.max(answer,sum);
            }
            right++;
        }
        return answer/k;
    }
}