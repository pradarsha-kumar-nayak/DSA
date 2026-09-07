class Solution {
    // int n;
    // int m;
    // public int helper(String s, String t, int i, int j,int dp[][]){
    //     if(j== m){
    //         return 1;
    //     }

    //     if(i == n){
    //         return 0;
    //     }

    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }
     
    //     if(s.charAt(i) == t.charAt(j)){
    //        int add= helper(s,t,i+1,j+1,dp);
    //        int skip= helper(s,t,i+1,j,dp);

    //        return dp[i][j]=add+skip;
    //     }else{
    //        return dp[i][j]=helper(s,t,i+1,j,dp);
    //     }
        

    // }
    public int numDistinct(String s, String t) {
       int n=s.length();
       int m=t.length();

        int dp[][]=new int[n+1][m+1];

        //buttomup
         
         for(int i=0;i<n+1;i++){
            dp[i][0]=1;
         }

         for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
         }

   return dp[n][m];
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             dp[i][j]=-1;
    //         }
    //     }

    //    return helper(s,t,0,0,dp);
    }
}