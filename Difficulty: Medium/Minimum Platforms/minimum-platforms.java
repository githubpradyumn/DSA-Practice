class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int n = arr.length;
        int m = dep.length;
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 0; // t
        int j = 0;
        
        int pf = 0;
        int maxpf = 0;
        
        while(i<n&&j<n){
            if(arr[i]<=dep[j]){
                pf++;
                maxpf=Math.max(pf,maxpf);
                i++;
            } else {
                pf--;
                j++;
            }
        }
        return maxpf;
    }
}
