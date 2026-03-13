class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int low = 1;
        int high = 0;
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            high =  Math.max(high,arr[i]);
        }
        while(low<=high){
            int middle = low + (high-low)/2;
            if(isValid(middle,k,arr)){
                ans = middle;
                high = middle - 1 ;
            } else {
                low = middle + 1;
            }
        }
        return ans;
    }
    public boolean isValid(int value,int k,int[] arr){
        int time=0;
        for(int i=0;i<arr.length;i++){
            time += Math.ceil((double)arr[i]/value);
        }
        if(time<=k) return true;
        return false;
    }
}
