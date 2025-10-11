class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double avg = 0;
        double max = Integer.MIN_VALUE;
        double sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i==k-1){
                avg=sum/k;
                max=Math.max(max,avg);
            } else if (i>=k){
                sum = sum - nums[i-k];
                avg=sum/k;
                max=Math.max(max,avg);
            }
        }
        return max;
    }
}