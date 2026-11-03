class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        for(int num: nums){
            if(max<num){
                max = num;
            }
        }
        int sum = 0;
        for(int num : nums){
            sum += max - num;
        }
        return sum;
    }
}