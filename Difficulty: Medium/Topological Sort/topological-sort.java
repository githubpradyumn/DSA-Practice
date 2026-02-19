class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<V;i++) adjlist.add(new ArrayList<>());
        
        for(int[] e : edges){
            adjlist.get(e[0]).add(e[1]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] degree = new int[V];
        for(int i=0;i<V;i++){
            for(int nbr:adjlist.get(i)){
                degree[nbr]++;
            }
        }
        for(int i=0;i<V;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            for(int nbr:adjlist.get(curr)){
                degree[nbr]--;
                if(degree[nbr]==0){
                    q.add(nbr);
                }
            }
        }
        return ans;
    }
}