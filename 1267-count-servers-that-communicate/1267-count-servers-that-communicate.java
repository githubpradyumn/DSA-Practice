import java.util.*;

class Solution {

    class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int countServers(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int result = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 1 && !visited[i][j]){

                    int size = bfs(grid, visited, i, j);

                    if(size > 1){
                        result += size;
                    }
                }
            }
        }

        return result;
    }

    private int bfs(int[][] grid, boolean[][] visited, int r, int c){

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(r, c));
        visited[r][c] = true;

        int count = 1;

        while(!q.isEmpty()){

            Pair cur = q.poll();
            int x = cur.r;
            int y = cur.c;

            for(int j = 0; j < n; j++){
                if(grid[x][j] == 1 && !visited[x][j]){
                    visited[x][j] = true;
                    q.offer(new Pair(x, j));
                    count++;
                }
            }

            for(int i = 0; i < m; i++){
                if(grid[i][y] == 1 && !visited[i][y]){
                    visited[i][y] = true;
                    q.offer(new Pair(i, y));
                    count++;
                }
            }
        }

        return count;
    }
}

