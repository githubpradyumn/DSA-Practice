class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int[] vis = new int[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                vis[i] = 0;
                dfs(isConnected, V, vis, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int V, int[] vis,int start){
        vis[start]=1;
        for(int i = 0;i<V;i++){
            if((isConnected[start][i]==1) && (vis[i]==0)){
                dfs(isConnected,V,vis,i);
            }
        }
        
    }   
}