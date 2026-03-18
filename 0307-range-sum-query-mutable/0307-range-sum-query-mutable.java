class NumArray {
    SegmentTree st;
    class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 1, 0, n - 1);
        }

        void build(int[] arr, int node, int start, int end) {

            if (start == end) {
                tree[node] = arr[start];
                return;
            }

            int mid = start + (end - start) / 2;

            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);

            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        int query(int node, int start, int end, int l, int r) {

            // No overlap
            if (r < start || end < l)
                return 0;

            // Complete overlap
            if (l <= start && end <= r)
                return tree[node];

            int mid = start + (end - start) / 2;

            int left = query(2 * node, start, mid, l, r);
            int right = query(2 * node + 1, mid + 1, end, l, r);

            return left + right;
        }

        void update(int node, int start, int end, int index, int value) {
            if (start == end) {
                tree[node] = value;
                return;
            }
            int mid = start + (end - start) / 2;
            if (index <= mid)
                update(2 * node, start, mid, index, value);
            else
                update(2 * node + 1, mid + 1, end, index, value);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    public NumArray(int[] nums) {
        st = new SegmentTree(nums);
    }

    public void update(int index, int val) {
        st.update(1,0,st.n-1,index,val);
    }

    public int sumRange(int left, int right) {
        return st.query(1, 0, st.n - 1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */