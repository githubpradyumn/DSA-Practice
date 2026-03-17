class GfG {
    static int st[];
    
    public static int[] constructST(int arr[], int n) {
        st = new int[4 * n];
        build(arr, 1, 0, n - 1);
        return st;
    }
    public static void build(int[] arr, int node, int start, int end) {

        if (start == end) {
            st[node] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);

        // Store minimum instead of sum
        st[node] = Math.min(st[2 * node], st[2 * node + 1]);
    }

    public static int RMQ(int st[], int n, int l, int r) {
        return query(1, 0, n - 1, l, r);
    }


    public static int query(int node, int start, int end, int l, int r) {

        // No overlap
        if (r < start || end < l)
            return Integer.MAX_VALUE;

        // Complete overlap
        if (l <= start && end <= r)
            return st[node];

        int mid = start + (end - start) / 2;

        int left = query(2 * node, start, mid, l, r);
        int right = query(2 * node + 1, mid + 1, end, l, r);

        return Math.min(left, right);
    }
}