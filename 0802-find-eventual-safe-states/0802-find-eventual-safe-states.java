class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<V;i++) adjlist.add(new ArrayList<>());
        for(int i=0;i<V;i++){
            for(int nb : graph[i]){
                adjlist.get(nb).add(i);
            }
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
        Collections.sort(ans);
        return ans;
    }
}