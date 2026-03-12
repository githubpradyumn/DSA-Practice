class Solution {

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return;

            if(rank[pa] > rank[pb]){
                parent[pb] = pa;
            }
            else if(rank[pa] < rank[pb]){
                parent[pa] = pb;
            }
            else{
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    public int numSimilarGroups(String[] strs) {

        int n = strs.length;
        DSU dsu = new DSU(n);

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i], strs[j])){
                    dsu.union(i, j);
                }
            }
        }

        int groups = 0;

        for(int i=0;i<n;i++){
            if(dsu.find(i) == i){
                groups++;
            }
        }

        return groups;
    }

    public boolean isSimilar(String a, String b){

        int diff = 0;

        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
                if(diff > 2) return false;
            }
        }

        return true;
    }
}