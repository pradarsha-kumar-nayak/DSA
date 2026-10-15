class Solution {
    public int solve(int n,int dp[]){
        

        if(dp[n] !=-1){
            return dp[n];
        }
        int res=Integer.MIN_VALUE;

        for(int i=1;i<=n-1;i++){

            int ans=i*Math.max(n-i,solve(n-i,dp));
            res=Math.max(res,ans);
        }

        return dp[n]=res;
    }
    public int integerBreak(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}