class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    int[] Row = {-1,1,0,0};
    int[] Col = {0,0,-1,1};
    public boolean isValid(int row, int col, int m, int n){
        return (row>=0 && col>=0 && row<m && col<n);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] isVisited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isVisited[i][j]==0 && grid[i][j]=='1'){
                    bfs(grid,isVisited,m,n,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,int[][] isVisited, int m, int n, int row, int col){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        isVisited[row][col] = 1;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0;i<4;i++){
                int currRow = curr.row + Row[i];
                int currCol = curr.col + Col[i];
                if(isValid(currRow,currCol,m,n)&&grid[currRow][currCol]=='1'&&isVisited[currRow][currCol]==0){
                    q.add(new Pair(currRow, currCol));
                    isVisited[currRow][currCol] = 1;
                }
            }
        }
    }

}