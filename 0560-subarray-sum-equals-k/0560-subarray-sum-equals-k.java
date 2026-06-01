class Solution {
    public int subarraySum(int[] nums, int k) {
        // int n = nums.length;
        // int count = 0;
        // for(int i=0;i<n;i++){ // runs n-times 
        //     for(int j=i;j<n;j++){ // runs n-times 
        //         int sum = 0;
        //         for(int l=i;l<=j;l++){ //run n-times
        //             sum+=nums[l];
        //         }
        //         if(sum==k) count++;
        //     }
        // }
        // // in total time comple = O(n^3)
        // // Which gives TLE at 61
        // return count;

        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){ //runs n-times
            int sum = 0;
            for(int j=i;j<n;j++){ //runs n-times
                sum+=nums[j]; //runs one time
                if(sum==k) count++; //runs one time
            }
        }
        // in total time complexity = O(n^2)
        return count;
    }
}