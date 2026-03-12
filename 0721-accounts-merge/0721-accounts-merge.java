import java.util.*;

class Solution {

    class DSU{
        
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
            else if(rank[pb] > rank[pa]){
                parent[pa] = pb;
            }
            else{
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        DSU dsu = new DSU(n);

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){

            List<String> acc = accounts.get(i);

            for(int j=1;j<acc.size();j++){
                String email = acc.get(j);
                if(!map.containsKey(email)){
                    map.put(email,i);
                }
                else{
                    dsu.union(i,map.get(email));
                }
            }
        }

        HashMap<Integer,TreeSet<String>> merged = new HashMap<>();

        for(String email : map.keySet()){
            int parent = dsu.find(map.get(email));
            merged.putIfAbsent(parent,new TreeSet<>());
            merged.get(parent).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for(int parent : merged.keySet()){
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(parent).get(0));
            temp.addAll(merged.get(parent));
            result.add(temp);
        }

        return result;
    }
}
