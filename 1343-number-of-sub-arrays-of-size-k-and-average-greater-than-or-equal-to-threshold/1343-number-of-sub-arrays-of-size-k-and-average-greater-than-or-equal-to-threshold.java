class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int right = 0, left = 0;
        int sum = 0;
        int count = 0;
        while(right<arr.length){
            sum += arr[right];
            while((right-left+1)>k){
                sum -= arr[left];
                left++;
            }
            if((right-left+1)==k){
                if((sum/k)>=threshold){
                    count++;
                }
            }
            right++;
        }
        return count;
    }
}