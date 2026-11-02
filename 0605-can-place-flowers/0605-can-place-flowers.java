class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        int length = nums.length;
        if (length == 1){
            if (nums[0] == 1 && n == 1) return false;
            else return true;
        }
        if(n==0) return true;
        if(nums[0]==0 && nums[1]==0 && n>0){
            n--;
            nums[0]=1;
        } 

         if(nums[length-1]==0 && nums[length-2]==0 && n>0){
            n--;
            nums[length-1]=1;
        } 
        
        for(int i=1;i<nums.length-1;i++){
            if(nums[i-1]==0 && nums[i+1]==0 && nums[i]==0 && n>0){
                n--;
                nums[i] = 1; 
            }
        }

        return n<=0?true:false;
    }
}