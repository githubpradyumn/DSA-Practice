class Solution {

    class Pair {
        int effort, r, c;
        Pair(int effort, int r, int c){
            this.effort = effort;
            this.r = r;
            this.c = c;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++)
            Arrays.fill(dist[i], (int)1e9);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.effort - b.effort
        );

        dist[0][0] = 0;
        pq.add(new Pair(0,0,0));

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()){

            Pair p = pq.poll();
            int effort = p.effort;
            int r = p.r;
            int c = p.c;

            if(r == n-1 && c == m-1)
                return effort;

            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m){

                    int wt = Math.abs(
                        heights[r][c] - heights[nr][nc]
                    );

                    int newEffort = Math.max(effort, wt);

                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        pq.add(new Pair(newEffort, nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}