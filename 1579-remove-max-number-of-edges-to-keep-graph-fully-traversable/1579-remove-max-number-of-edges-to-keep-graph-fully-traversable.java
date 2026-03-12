import java.util.*;

class Solution {

    class DSU {
        int[] parent;
        int[] rank;
        int components;

        DSU(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            components = n;

            for(int i=1;i<=n;i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int a, int b){

            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return false;

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

            components--;
            return true;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        int remove = 0;

        Arrays.sort(edges, (a,b) -> b[0] - a[0]);

        for(int[] e : edges){

            int type = e[0];
            int u = e[1];
            int v = e[2];

            if(type == 3){

                boolean a = alice.union(u,v);
                boolean b = bob.union(u,v);

                if(!a && !b) remove++;

            } else if(type == 1){

                if(!alice.union(u,v)) remove++;

            } else{

                if(!bob.union(u,v)) remove++;
            }
        }

        if(alice.components != 1 || bob.components != 1){
            return -1;
        }

        return remove;
    }
}