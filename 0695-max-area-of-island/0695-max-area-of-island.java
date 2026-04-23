class Solution {
    class Pair {
        int row, col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    int[] rowDirections = {0,0,-1,1};
    int[] colDirections = {-1,1,0,0};
    public boolean isValid(int row, int col, int totalRows, int totalCols){
        return (row>=0 && col>=0 && row<totalRows && col<totalCols);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int maxCount = 0;
        int[][] isVisited = new int[totalRows][totalCols];
        for(int i=0;i<totalRows;i++){
            for(int j=0;j<totalCols;j++){
                if(grid[i][j]==1 && isVisited[i][j]==0){
                    int count = bfs(grid,isVisited,i,j,totalRows,totalCols);
                    maxCount = Math.max(maxCount,count);
                    // bfs(grid,isVisited,i,j,totalRows,totalCols);
                    // maxCount++;
                }
            }
        }
        return maxCount;
    }
    public int  bfs(int[][] grid, int[][] isVisited, int row, int col, int totalRows, int totalCols){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        isVisited[row][col]=1;
        int currCount = 1;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0;i<4;i++){
                int currRow = curr.row + rowDirections[i];
                int currCol = curr.col + colDirections[i];
                if(isValid(currRow,currCol,totalRows,totalCols) && grid[currRow][currCol]==1 && isVisited[currRow][currCol]==0){
                    isVisited[currRow][currCol]=1;
                    q.add(new Pair(currRow,currCol));
                    currCount++;
                }
            }
        }

        return currCount;
    }
}