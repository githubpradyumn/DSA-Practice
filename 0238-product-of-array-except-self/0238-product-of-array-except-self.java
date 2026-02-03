class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int total_product = 1;
        int count = 0;
        int index = 0;

        for(int i=0; i<n; i++){
            if(nums[i]==0){
                count++;
                index=i;
            } else {
                total_product *= nums[i];
            }
        }
        if(count>1){
            return ans;
        } else if(count==1){
            ans[index]=total_product;
        } else {
            for(int i=0; i<n; i++){
                ans[i]=total_product/nums[i];
            }
        }
        return ans;
    }
}