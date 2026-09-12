class Solution {
    
    public int minimumTotal(List<List<Integer>> arr) {
      int n=arr.size();
      int m=arr.get(n-1).size();
      int dp[][]=new int[n][m];

      for(int i=0;i<m;i++){
        dp[n-1][i]=arr.get(n-1).get(i);
      }

      for(int i=n-2;i>=0;i--){

        for(int j=0;j<arr.get(i).size();j++){
            dp[i][j]=Math.min(dp[i+1][j]+arr.get(i).get(j),
                              dp[i+1][j+1]+arr.get(i).get(j));
        }
      }

      return dp[0][0];

    }
}