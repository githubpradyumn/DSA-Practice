class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int max = 0;
        if(max<gain[0]){
            max=gain[0];
        }
        for(int i=1; i<n; i++){
            gain[i] += gain[i-1];
            if(gain[i]>max){
                max=gain[i];
            }
        }
        return max;
    }
}