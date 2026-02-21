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
    public int numIslands(char[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int count = 0;
        int[][] isVisited = new int[totalRows][totalCols];
        for(int i=0;i<totalRows;i++){
            for(int j=0;j<totalCols;j++){
                if(grid[i][j]=='1' && isVisited[i][j]==0){
                    bfs(grid,isVisited,i,j,totalRows,totalCols);
                    count++;
                }
            }
        }
    return count;
    }
    public void bfs(char[][] grid, int[][] isVisited, int row, int col, int totalRows, int totalCols){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        // isVisited[row][col]=1;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0;i<4;i++){
                int currRow = curr.row + rowDirections[i];
                int currCol = curr.col + colDirections[i];
                if(isValid(currRow,currCol,totalRows,totalCols) && grid[currRow][currCol]=='1' && isVisited[currRow][currCol]==0){
                    isVisited[currRow][currCol]=1;
                    q.add(new Pair(currRow,currCol));
                }
            }
        }
    }
}