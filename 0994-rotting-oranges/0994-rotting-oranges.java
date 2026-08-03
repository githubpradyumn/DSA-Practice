class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    int dr[] = {0,0,-1,1};
    int dc[] = {-1,1,0,0};
    
    public boolean isValid(int row, int col, int totalRow, int totalCol){
        return (row>=0 && col>=0 && totalRow>row && totalCol>col); 
    }

    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;
        
        int n = grid[0].length;

        int freshOrange = 0;
        int time = 0;
        boolean fresh = false;

        Queue<Pair> q = new LinkedList<>();
        int[][] isVisited = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2 && isVisited[i][j]==0){
                    q.add(new Pair(i,j));
                    isVisited[i][j]=1;
                } else if (grid[i][j]==1){
                    freshOrange++;
                }
            }
        }
        
        while(!q.isEmpty()){

            int size = q.size();
            
            while(size>0){
            
                Pair curr = q.poll();
                
                for(int i=0;i<4;i++){

                    int currRow = curr.row + dr[i];
                    int currCol = curr.col + dc[i];

                    if(isValid(currRow,currCol,m,n) && isVisited[currRow][currCol]==0 && grid[currRow][currCol]==1){
                        q.add(new Pair(currRow, currCol));
                        isVisited[currRow][currCol]=1;
                        freshOrange--;
                        fresh = true;
                    }
                }
                size--;
            }

            if(fresh){
                time++;
                fresh = false;
            }

        }

        if(freshOrange!=0){
            return -1;
        }


        return time;
    }
}