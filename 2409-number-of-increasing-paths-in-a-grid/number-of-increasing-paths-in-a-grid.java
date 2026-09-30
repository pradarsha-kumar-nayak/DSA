class Solution {
    int n;
    int m;
    int dp[][];
    int mod;
    public int helper(int grid[][],int row,int col){
        
        if(dp[row][col] !=-1){
            return dp[row][col];
        }

        long result=1;

        //right
        if(col+1 <m && grid[row][col+1] < grid[row][col]){
            result=(result+helper(grid,row,col+1))%mod;
        }

        //left
        if(col-1 >=0 && grid[row][col-1] < grid[row][col]){
            result=(result+helper(grid,row,col-1))%mod;
        }

        //top
        if(row-1 >=0 && grid[row-1][col] < grid[row][col]){
           result=(result+helper(grid,row-1,col))%mod;
        }

        //butoom
        if(row+1 <n && grid[row+1][col] < grid[row][col]){
            result=(result+helper(grid,row+1,col))%mod;
        }

        return dp[row][col]=(int)result;
    }
    public int countPaths(int[][] grid) {
       n=grid.length;
       m=grid[0].length;
       dp=new int[n][m];

       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            dp[i][j]=-1;
        }
       }
        mod=1000000007;
       int ans=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
           ans=(ans+ helper(grid,i,j))%mod;
        }
       }

       return ans;
    }
}