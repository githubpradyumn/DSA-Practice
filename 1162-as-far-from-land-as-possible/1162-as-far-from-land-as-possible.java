class Solution {
    
    class Pair{
        int row;
        int col;
        
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    
    int rowsDirection[] = {0,0,-1,1};
    int colsDirection[] = {-1,1,0,0};
    
    public boolean isValid(int r,int c,int n){
        return (r>=0 && r<n && c>=0 && c<n);
    }
    
    public int maxDistance(int[][] grid) {
        
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        return bfs(grid,visited,n);

    }
    
    public int bfs(int[][] grid, boolean[][] visited, int n){
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j));
                    visited[i][j]=true;
                }
            }
        }
        
        if(q.isEmpty() || q.size()==n*n){
            return -1;
        }
        
        int distance = -1;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            distance++;
            
            for(int s=0;s<size;s++){
                
                Pair curr = q.poll();
                int currRow = curr.row;
                int currCol = curr.col;
                
                for(int i=0;i<4;i++){
                    
                    int newRow = currRow + rowsDirection[i];
                    int newCol = currCol + colsDirection[i];
                    
                    if(isValid(newRow,newCol,n) && !visited[newRow][newCol]){
                        visited[newRow][newCol]=true;
                        q.add(new Pair(newRow,newCol));
                    }
                }
            }
        }
        
        return distance;
    }
}
