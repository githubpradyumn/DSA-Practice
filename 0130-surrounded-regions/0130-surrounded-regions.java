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
    public void bfs(char[][] board,int[][] isVisited,int m, int n, int i, int j){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        board[i][j]='A';
        isVisited[i][j]=1;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int k=0;k<4;k++){
                int currRow=curr.row+row[k];
                int currCol=curr.col+col[k];
                if(isValid(currRow,currCol,m,n)&&isVisited[currRow][currCol]==0&&board[currRow][currCol]=='O'){
                    q.add(new Pair(currRow,currCol));
                    board[currRow][currCol]='A';
                    isVisited[currRow][currCol]=1;
                }
            }
        }
    }
    public void solve(char[][] board) {
       int m = board.length;
       int n = board[0].length;
       
       int isVisited[][] = new int[m][n];

       for(int i=0;i<n;i++){
        if(isVisited[0][i]==0&&board[0][i]=='O'){
            bfs(board,isVisited,m,n,0,i);
        }
       } 
       for(int i=0;i<n;i++){
        if(isVisited[m-1][i]==0&&board[m-1][i]=='O'){
            bfs(board,isVisited,m,n,m-1,i);
        }
       } 
       for(int i=0;i<m;i++){
        if(isVisited[i][0]==0&&board[i][0]=='O'){
            bfs(board,isVisited,m,n,i,0);
        }
       } 
       for(int i=0;i<m;i++){
        if(isVisited[i][n-1]==0&&board[i][n-1]=='O'){
            bfs(board,isVisited,m,n,i,n-1);
        }
       } 

       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(board[i][j]=='A'){
                board[i][j]='O';
            } else {
                board[i][j]='X';
            }
        }
       }
    }
}