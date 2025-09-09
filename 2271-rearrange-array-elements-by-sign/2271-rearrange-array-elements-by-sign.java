class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int b = 1;
        int c = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i]>=0){
                temp[c] = nums[i];
                c = c + 2;
            } else {
                temp[b] = nums[i];
                b = b + 2;
            }
        }
        // for(int i = 0 ; i < n ; i++){}
    return temp;
    }
}