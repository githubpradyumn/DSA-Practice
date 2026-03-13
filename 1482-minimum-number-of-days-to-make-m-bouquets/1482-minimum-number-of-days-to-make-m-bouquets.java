class Solution {   
    public int minDays(int[] arr, int m, int k) {

        if(m * k > arr.length) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            low = Math.min(low, arr[i]);
            high = Math.max(high, arr[i]);
        }

        int ans = -1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isValid(arr, k, m, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] arr, int k, int m, int day){

        int flowers = 0;
        int bouquets = 0;

        for(int i = 0; i < arr.length; i++){

            if(arr[i] <= day){
                flowers++;
            }
            else{
                flowers = 0;
            }

            if(flowers == k){
                bouquets++;
                flowers = 0;
            }

            if(bouquets >= m) return true;
        }

        return false;
    }
}