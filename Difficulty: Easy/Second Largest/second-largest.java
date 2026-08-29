class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int a = arr[0], b = -1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>a){
                b=a;
                a=arr[i];
            } else if (arr[i]>b && arr[i]!=a){
                b = arr[i];
            }
        }
        return b;
    }
}