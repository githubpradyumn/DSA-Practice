class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});

        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        int s = 0; 

        while (!q.isEmpty()) {
            int size = q.size();
            if(s > K) break;
            
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int node = curr[0];
                int cost = curr[1];

                for (int[] neighbor : adj.get(node)) {
                    int adjNode = neighbor[0];
                    int edgeWeight = neighbor[1];

                    if(cost + edgeWeight < dist[adjNode]) {
                        dist[adjNode] = cost + edgeWeight;
                        q.offer(new int[]{adjNode, dist[adjNode]});
                    }
                }
            }
            s++;
        }

        return dist[dst] == (int)1e9 ? -1 : dist[dst];
    }
}