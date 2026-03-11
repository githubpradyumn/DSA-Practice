// User function Template for Java
class Solution {
    static class DSU{
        int[] parent;
        int[] rank;
        
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        
        public int find(int x){
            if(parent[x]!=x){
                return parent[x] = find(parent[x]);
            }
            return x;
        }
        
        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);
            
            if(pa==pb) return;
            if(rank[pa]>rank[pb]){
                parent[pb]=pa;
            } else if(rank[pa]<rank[pb]){
                parent[pa]=pb;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        int n = edges.length;
        DSU obj = new DSU(V);
        int cost = 0;
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        for(int i=0;i<n;i++){
            int u = edges[i][0]; 
            int v = edges[i][1]; 
            int w = edges[i][2]; 
            
            int pu = obj.find(u);
            int pv = obj.find(v);
            
            if(pu!=pv){
                obj.union(u,v);
                cost += w;
            }
        }
        return cost;
        
    }
}
