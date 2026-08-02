class Solution {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }

    int row[] = {-1,1,0,0};
    int col[] = {0,0,1,-1};

    public boolean isValid(int row,int col, int m, int n){
        return (row>=0 && row<m && col>=0 && col<n);
    }
    public int bfs(int[][] grid,int[][] isVisited,int m, int n, int i, int j,int max){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        isVisited[i][j]=1;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            max += grid[curr.row][curr.col];
            for(int k=0;k<4;k++){
                int currRow=curr.row+row[k];
                int currCol=curr.col+col[k];
                if(isValid(currRow,currCol,m,n)&&isVisited[currRow][currCol]==0&&grid[currRow][currCol]>0){
                    q.add(new Pair(currRow,currCol));
                    isVisited[currRow][currCol]=1;
                }
            }
        }
        return max;
    }
    public int findMaxFish(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;

        int[][] isVisited = new int[m][n];

        int maxFish=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isVisited[i][j]==0 && grid[i][j]>0){
                    int max=bfs(grid,isVisited,m,n,i,j,0);
                    maxFish=Math.max(maxFish,max);
                }
            }
        }
        return maxFish;

    }
}