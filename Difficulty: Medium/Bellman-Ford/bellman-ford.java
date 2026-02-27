class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {

        int[] dist = new int[V];
        int INF = 100000000;
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for(int i = 1; i <= V-1; i++){
            for(int[] e : edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];

                if(dist[u] != INF && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            if(dist[u] != INF && dist[u] + w < dist[v]){
                return new int[]{-1};
            }
        }

        return dist;
    }
}