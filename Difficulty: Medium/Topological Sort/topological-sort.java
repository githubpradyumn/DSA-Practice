class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjlist.get(u).add(v);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] visited  = new int[V];
        for(int i=0; i<V;i++){
            if(visited[i]!=1){
                dfs(adjlist,stack,visited,i);
            }
        }
        while(!stack.isEmpty()){
            answer.add(stack.pop());
        }
        return answer;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adjlist,Stack<Integer> stack, int[] visited, int node){
        visited[node] = 1;
        for(int nbh : adjlist.get(node) ){
            if(visited[nbh]!=1){
                dfs(adjlist,stack,visited,nbh);
            }
        }
        stack.push(node);
    }
}