class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = nums[i]*nums[i];
        }
        int k = nums.length-1;
        int i = 0;
        int j = nums.length-1;
        while(i<=j){
            if(nums[i]>nums[j]){
                answer[k--] = nums[i++]; 
            } else {
                answer[k--] = nums[j--];
            }
        }
        return answer;
    }
}