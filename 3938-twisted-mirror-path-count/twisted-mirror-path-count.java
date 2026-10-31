class Solution {
    int n;
    int m;
    int mod=1000000007;
    public int solve(int[][] grid,int i,int j,String dir ,int dp[][][]){
       if(j== m || i==n){
        return 0;
       }

        int d = dir.equals("r") ? 0 : 1;


       if(dp[i][j][d] != -1){
          return dp[i][j][d];
       }

       if(i==n-1 && j==m-1){
        return 1;
       }

       if(grid[i][j] ==1){
          
          if(dir.equals("r") && i+1 <n){
             
             return dp[i][j][d]= solve(grid,i+1,j,"d",dp);
          }
          else if( dir.equals("r") && i+1 ==n){
             return 0;
          }
          else if(dir.equals("d") && j+1 < m ){
             return dp[i][j][d]= solve(grid,i,j+1,"r",dp);
          }
          else if( dir.equals("d") && j+1 == m){
            return 0;
          }
       }


       int right=solve(grid,i,j+1,"r",dp);
       int down=solve(grid,i+1,j,"d",dp);
       
       return dp[i][j][d]= (right+down)%mod;
    }
    public int uniquePaths(int[][] grid) {
       
        n=grid.length;
        m=grid[0].length;
        
         int dp[][][]=new int[n][m][2];

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               Arrays.fill(dp[i][j],-1);
            }
         }

        return solve(grid,0,0,"r",dp);
    }
}