class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int windowStart = 0;
        int windowEnd = 0;
        int currAvg = 0;
        int count = 0;
        while(windowEnd<arr.length){
            currAvg += arr[windowEnd];
            if(windowEnd>=k-1){
                if((currAvg/k)>=threshold){
                    count++;
                }
                currAvg -= arr[windowStart];
                windowStart++;
            }
            windowEnd++;
        }
        return count;
    }
}