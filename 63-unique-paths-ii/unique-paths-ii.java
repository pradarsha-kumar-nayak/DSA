class Solution {
    int n;
    int m;
    // public int helper(int matrix[][], int i,int j,int dp[][]){
    //     if(i==n || j==m){
    //         return 0;
    //     }

    //     if(matrix[i][j] == 1){
    //         return 0;
    //     }
    //     if(i==n-1 && j==m-1){
    //         return 1;
    //     }

    //     if(dp[i][j] !=-1){
    //         return dp[i][j];
    //     }

    //     int right=helper(matrix,i,j+1,dp);
    //     int down=helper(matrix,i+1,j,dp);

    //     return dp[i][j]=right+down;
    // }
    public int uniquePathsWithObstacles(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int dp[][]=new int[n][m];

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         dp[i][j]=-1;
        //     }
        // }

        if(n==1 && m==1 && grid[0][0]==1){
            return 0;
        }
        
         dp[0][0]=(grid[0][0]==1)?0:1;

        for(int i=1;i<m;i++){
            if(grid[0][i] ==0){
                dp[0][i]=dp[0][i-1];
            }
        }

        for(int j=1;j<n;j++){
           if(grid[j][0] ==0){
            dp[j][0]=dp[j-1][0];
           }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){

                if(grid[i][j]==1){
                    dp[i][j]=0;
                }else{

                 dp[i][j]=dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }
}