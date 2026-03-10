class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        int components;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            components=n;
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x]!=x){
                return parent[x] = find(parent[x]);
            }
            return x;
        }
        public void union(int a,int b){
            int pa = find(a);
            int pb = find(b);
            if(pa==pb) return;
            if(rank[pa]>rank[pb]){
                parent[pb]=pa;
            } else if(rank[pb]>rank[pa]){
                parent[pa]=pb;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
            components--;
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU obj = new DSU(n);

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int u = stones[i][0];
                int v = stones[i][1];

                int prevU = stones[j][0];
                int prevV = stones[j][1];

                if(u==prevU || v==prevV){
                    obj.union(i,j);
                }
            }
        }
        return n - obj.components;
    }
}