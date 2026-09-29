class Solution {
    int n;
    int m;
    int dp[][][];
    public int solve(char[][] grid,int row,int col,int brccnt){
        
        brccnt+=(grid[row][col]=='(')?1:-1;

        if(brccnt <0){
            return 0;
        }

        if(dp[row][col][brccnt] !=-1){
            return dp[row][col][brccnt];
        }

        if(row==n-1 && col==m-1){
           if(brccnt==0){
            return 1;
           }else{
            return 0;
           }
        }
        
        if(row+1 <n){
           if(solve(grid,row+1,col,brccnt)==1){
            return dp[row][col][brccnt]=1;
           }
        }

         if(col+1 <m){
           if(solve(grid,row,col+1,brccnt)==1){
            return dp[row][col][brccnt]=1;
           }
        }

        return dp[row][col][brccnt]=0;

    }
    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0] == ')'){
            return false;
        }

        n=grid.length;
        m=grid[0].length;

        dp=new int[101][101][201];

        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        
        int ans=solve(grid,0,0,0);
        return (ans==1)?true:false;
    }
}