class Solution {
    
    public int networkDelayTime(int[][] times, int V, int src) {

        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i = 1; i <= V-1; i++){
            for(int[] e : times){
                int u = e[0];
                int v = e[1];
                int w = e[2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }

        int maxTime = 0;

        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}