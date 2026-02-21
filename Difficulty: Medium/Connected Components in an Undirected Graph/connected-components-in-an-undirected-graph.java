class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjlist.add(new ArrayList<>());
        }
        for (int[] e:edges) {
            adjlist.get(e[0]).add(e[1]);
            adjlist.get(e[1]).add(e[0]);
        }
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        int[] isVisited = new int[V];
        for (int i = 0; i < V; i++) {
            if (isVisited[i] == 0) {
                bfs(adjlist, isVisited, i,ansList);
            }
        }
        return ansList;
    }
    public void bfs(ArrayList<ArrayList<Integer>> adjlist, int[] isVisited, int start, ArrayList<ArrayList<Integer>> ansList) {
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adjlist.size();
        Queue<Integer> q = new LinkedList<>();
        isVisited[start] = 1;
        q.add(start);

        while (!q.isEmpty()) {
            int currNode = q.poll();
            ans.add(currNode);
            for (int nbh : adjlist.get(currNode)) {
                if (isVisited[nbh] == 0) {
                    isVisited[nbh] = 1;
                    q.add(nbh);
                }
            }
        }
        ansList.add(ans);
    }
}