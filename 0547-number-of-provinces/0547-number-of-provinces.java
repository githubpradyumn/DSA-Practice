class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i=0; i<V; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V ; i++){
            for(int j = 0 ; j < V ; j++){
                if(isConnected[i][j] == 1){
                    list.get(i).add(j);
                }
            }
        }
        int[] vis= new int[V];
        int count = 0;
        for(int i = 0;i<V;i++){
            if(vis[i]==0){
                // vis[i]=1;
                // bfs(isConnected,V,vis,i);
                bfs(list,V,vis,i);
                count++;
            }
        }
        return count;
    }
    public void bfs(ArrayList<ArrayList<Integer>> list, int V, int[] vis,int idx){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        vis[idx]=1;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int nbr: list.get(curr)){
                if(vis[nbr]== 0){
                    vis[nbr] = 1;
                    q.add(nbr);
                }
            }
        }
    }
    // public void bfs(int[][] isConnected, int V, int[] vis,int idx){
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(idx);
    //     while(!q.isEmpty()){
    //         int curr = q.remove();
    //         for(int i=0;i<V;i++){
    //             if(isConnected[curr][i]==1 && vis[i]==0){
    //                 vis[i]=1;
    //                 q.add(i);
    //             }
    //         }
    //     }
    // }
}