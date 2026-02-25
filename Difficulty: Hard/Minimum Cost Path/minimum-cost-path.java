class Solution {

    class Pair {
        int cost, r, c;
        Pair(int cost, int r, int c){
            this.cost = cost;
            this.r = r;
            this.c = c;
        }
    }

    public int minimumCostPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++)
            Arrays.fill(dist[i], (int)1e9);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.cost - b.cost
        );

        dist[0][0] = grid[0][0];
        pq.add(new Pair(grid[0][0], 0, 0));

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()){

            Pair p = pq.poll();
            int cost = p.cost;
            int r = p.r;
            int c = p.c;

            if(r == n-1 && c == m-1)
                return cost;

            for(int i=0;i<4;i++){

                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m){

                    int newCost = cost + grid[nr][nc];

                    if(newCost < dist[nr][nc]){
                        dist[nr][nc] = newCost;
                        pq.add(new Pair(newCost, nr, nc));
                    }
                }
            }
        }

        return -1;
    }
}