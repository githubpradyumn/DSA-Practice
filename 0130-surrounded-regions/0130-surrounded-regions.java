class Solution {
    class Pair{

        int row;
        int col;        

        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }

    }
    public boolean isValid(int row,int col,int totalRows,int totalCols){
        if(row>0 && row<totalRows && col>0 && col<totalCols) return true;
        return false;
    }

    int[] rowDirection = {1,-1,0,0};
    int[] colDirection = {0,0,1,-1};

    public void bfs(boolean[][] isVisited,char[][] board,int row,int col,int totalRows, int totalCols){
        
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(row,col);
        q.add(p);
        isVisited[row][col] = true;
        board[row][col]='A';
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            int currRow = curr.row;
            int currCol = curr.col;;
            
            for(int i=0;i<4;i++){
                
                int newRow = currRow + rowDirection[i];
                int newCol = currCol + colDirection[i];
                
                if(isValid(newRow,newCol,totalRows,totalCols) && board[newRow][newCol]=='O' && isVisited[newRow][newCol]==false){
                    Pair currPair = new Pair(newRow,newCol);
                    q.add(currPair);
                    isVisited[newRow][newCol]=true;
                    board[newRow][newCol]='A';

                }
                
            }
        }
    }
    public void solve(char[][] board){
        
        int totalRows=board.length;
        int totalCols=board[0].length;
        boolean[][] isVisited = new boolean[totalRows][totalCols];

        for(int i=0;i<totalCols;i++){
            if(board[0][i]=='O' && isVisited[0][i]==false){
                bfs(isVisited,board,0,i,totalRows,totalCols);
            }
        }
        for(int i=0;i<totalCols;i++){
            if(board[totalRows-1][i]=='O' && isVisited[totalRows-1][i]==false){
                bfs(isVisited,board,totalRows-1,i,totalRows,totalCols);
            }
        }
        for(int i=0;i<totalRows;i++){
            if(board[i][0]=='O' && isVisited[i][0]==false){
                bfs(isVisited,board,i,0,totalRows,totalCols);
            }
        }
        for(int i=0;i<totalRows;i++){
            if(board[i][totalCols-1]=='O' && isVisited[i][totalCols-1]==false){
                bfs(isVisited,board,i,totalCols-1,totalRows,totalCols);
            }
        }

        for(int i=0;i<totalRows;i++){
            for(int j=0;j<totalCols;j++){
                if(board[i][j]=='A'){
                    board[i][j]='O';
                } else {
                    board[i][j]='X';
                }
            }
        }

    }
}