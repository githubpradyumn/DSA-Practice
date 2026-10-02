class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length==1){
            return  nums[0];
        }
        double answer = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        answer = Math.max(answer,sum);
        for(int i=k;i<nums.length;i++){
            sum += nums[i];
            sum -= nums[i-k];
            double avg = sum;
            answer = Math.max(answer,avg);
        }
        return answer/k;
    }
}