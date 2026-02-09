class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination){
            return true;
        }
        int m = edges.length;
        int[] vist = new int[n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int from = edges[i][0];
            int to = edges[i][1];

            list.get(from).add(to);
            list.get(to).add(from);
        }
        for(int i=0;i<n;i++){
            if(bfs(n,list,vist,source,destination)){
                return true;
            }
        }
        return false;
    }
    public boolean bfs(int n, ArrayList<ArrayList<Integer>> adjlist,int[] vist, int source,int destination){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vist[source] = 1;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int path : adjlist.get(curr)){
                if(path==destination){
                    return true;
                }
                if(vist[path]==0){
                    vist[path]=1;
                    q.add(path);
                }
            }
        }
        return false;
    }
}