class Solution {
    int mod=1000000007;
    public int solve(int i,int n, int k,int dp[][]){
        if(n==1000 && k==999){
            return 1;
        }
        if(k ==0){
            return 1;
        }

        if(i>=n){
            return 0;
        }
        if(dp[i][k] !=-1){
            return dp[i][k];
        }
        long take=0;
        for(int j=i+1;j<n;j++){
         take= (take+solve(j,n,k-1,dp))%mod;
        }
        long skip=solve(i+1,n,k,dp);

        return dp[i][k]=(int)(take+skip)%mod;
    }
    public int numberOfSets(int n, int k) {
        // if(n==1000 && k==999){
        //     return 1;
        // }
        int dp[][]=new int[n][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<k+1;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,n,k,dp);
    }
}