class Solution {

    class Pair {
        int r, c, maxHt;

        Pair(int r, int c, int maxHt){
            this.r = r;
            this.c = c;
            this.maxHt = maxHt;
        }
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;
        int[][] dist = new int[n][n];
        for(int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.maxHt - b.maxHt
        );

        dist[0][0] = grid[0][0];
        pq.add(new Pair(0,0,grid[0][0]));
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!pq.isEmpty()){
            
            Pair curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int currMax = curr.maxHt;

            if(r == n-1 && c == n-1) return currMax;

            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nc>=0 && nr<n && nc<n){
                    int newMax = Math.max(currMax, grid[nr][nc]);
                    if(newMax < dist[nr][nc]){
                        dist[nr][nc] = newMax;
                        pq.add(new Pair(nr,nc,newMax));
                    }
                }
            }
        }
        return -1;
    }
}