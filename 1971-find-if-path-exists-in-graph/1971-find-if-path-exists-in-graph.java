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
        return dfs(list,vist,source,destination);
    }
        public boolean dfs(ArrayList<ArrayList<Integer>> adjlist, int[] vist, int node, int destination){
        if(node == destination){
            return true;
        }
        vist[node] = 1;

        for(int neighbour : adjlist.get(node)){
            if(vist[neighbour] == 0){
                if(dfs(adjlist, vist, neighbour, destination)){
                    return true;
                }
            }
        }
        return false;
    }
}

