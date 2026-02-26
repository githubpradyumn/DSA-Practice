class Solution {

    class Pair {
        int cost, node, time;

        Pair(int cost, int node, int time) {
            this.cost = cost;
            this.node = node;
            this.time = time;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {

        int n = passingFees.length;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int[][] dist = new int[n][maxTime + 1];
        for(int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.cost - b.cost);

        dist[0][0] = passingFees[0];
        pq.add(new Pair(passingFees[0], 0, 0));

        while(!pq.isEmpty()){

            Pair curr = pq.poll();
            int cost = curr.cost;
            int node = curr.node;
            int time = curr.time;

            if(node == n - 1)
                return cost;

            for(int[] nei : adj.get(node)){

                int nextNode = nei[0];
                int edgeTime = nei[1];

                int newTime = time + edgeTime;
                if(newTime > maxTime)
                    continue;

                int newCost = cost + passingFees[nextNode];

                if(newCost < dist[nextNode][newTime]){
                    dist[nextNode][newTime] = newCost;
                    pq.add(new Pair(newCost, nextNode, newTime));
                }
            }
        }

        return -1;
    }
}