class Solution {
    int totalsum;
    public int solve(int i,int cursum, int nums[],int dp[][],int tar){
        if(i == nums.length){
            if(cursum ==tar){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[i][cursum+totalsum] !=-1){
            return dp[i][cursum+totalsum];
        }

        int pls=solve(i+1,cursum+nums[i],nums,dp,tar);
        int mns=solve(i+1,cursum-nums[i],nums,dp,tar);

        return dp[i][cursum+totalsum]=pls+mns;

    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        
        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];
        }
        int dp[][]=new int[n][totalsum*2+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<totalsum*2+1;j++){
                dp[i][j]=-1;
            }
        }

      return  solve(0,0,nums,dp,target);
    }
}