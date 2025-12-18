class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int[] vis= new int[V];
        int count = 0;
        for(int i = 0;i<V;i++){
            if(vis[i]==0){
                vis[i]=1;
                bfs(isConnected,V,vis,i);
            
                count++;
            }
        }
        return count;
    }
    public void bfs(int[][] isConnected, int V, int[] vis,int idx){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i=0;i<V;i++){
                if(isConnected[curr][i]==1 && vis[i]==0){
                    vis[i]=1;
                    q.add(i);
                }
            }
        }
        // return vis;
    }
}