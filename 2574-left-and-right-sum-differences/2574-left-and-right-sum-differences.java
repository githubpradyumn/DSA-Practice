class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length; 
        int[] leftsum = new int[n];
        int[] rightsum = new int[n];
        for(int i=1,j=n-2;i<n&&j>=0;i++,j--){
            leftsum[i]=leftsum[i-1]+nums[i-1];
            rightsum[j]=rightsum[j+1]+nums[j+1];
        }
        for(int i=0;i<n;i++){
            nums[i]=Math.abs(leftsum[i]-rightsum[i]);
        }
        return nums;
    }
}