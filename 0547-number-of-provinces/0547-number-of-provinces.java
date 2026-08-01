class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1){
                    adjlist.get(i).add(j);
                }
            }
        }
        int[] visited = new int[V];
        int count = 0;
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                bfs(adjlist,visited,i);
                count++;
            }
        }
        return count;
    }
    public void bfs(ArrayList<ArrayList<Integer>> adjlist ,int[] visited, int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = 1;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int nbh:adjlist.get(curr)){
                if(visited[nbh]!=1){
                    visited[nbh]=1;
                    q.add(nbh);
                }
            }
        }
    }
}