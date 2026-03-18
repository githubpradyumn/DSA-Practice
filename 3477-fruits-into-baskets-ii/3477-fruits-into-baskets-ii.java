class Solution {
    // class SegmentTree {
    //     int[] tree;
    //     int n;

    //     SegmentTree(int[] arr) {
    //         n = arr.length;
    //         tree = new int[4 * n];
    //         build(arr, 1, 0, n - 1);
    //     }

    //     void build(int[] arr, int node, int start, int end) {

    //         if (start == end) {
    //             tree[node] = arr[start];
    //             return;
    //         }

    //         int mid = start + (end - start) / 2;

    //         build(arr, 2 * node, start, mid);
    //         build(arr, 2 * node + 1, mid + 1, end);

    //         tree[node] = tree[2 * node] + tree[2 * node + 1];
    //     }

    //     int query(int node, int start, int end, int l, int r) {

    //         // No overlap
    //         if (r < start || end < l)
    //             return 0;

    //         // Complete overlap
    //         if (l <= start && end <= r)
    //             return tree[node];

    //         int mid = start + (end - start) / 2;

    //         int left = query(2 * node, start, mid, l, r);
    //         int right = query(2 * node + 1, mid + 1, end, l, r);

    //         return left + right;
    //     }
    // }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int[] arr = new int[n];
        int[] basketFill = new int[n]; 
        for(int i=0; i<n; i++){
            int idx = 0;
            while(idx < n){
                if((fruits[i]<=baskets[idx]) && (basketFill[idx]==0)){
                    arr[i]=1;
                    basketFill[idx]=1;
                    break;
                }
                idx++;
            }
        }
        int basketUsed = 0;
        for(int i=0; i<n; i++){
            if(basketFill[i]==1){
                basketUsed++;
            }
        }
        // SegmentTree st = new SegmentTree(arr);

        // int basketUsed = st.query(1, 0, n - 1, 0, n - 1);

        return n - basketUsed;
    }
}