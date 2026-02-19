class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<V;i++) adjlist.add(new ArrayList<>());
        for(int i=0;i<V;i++){
            for(int nb : graph[i]){
                adjlist.get(i).add(nb);
            }
        }
        int[] color = new int[V];
        for(int i=0;i<V;i++)
            color[i] = -1;
        for(int i=0;i<V;i++){
            if(color[i] == -1){
                if(!bfsCheck(i,adjlist,color)){
                    return false;
                }
            }
        }
        return true;
    }
     public boolean bfsCheck(int start, ArrayList<ArrayList<Integer>> adj, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nb : adj.get(node)){
                if(color[nb] == -1){
                    color[nb] = 1 - color[node];
                    q.add(nb);
                }
                else if(color[nb] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}