class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int a=0, b=arr.length-1;
        while(a<b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
    }
}