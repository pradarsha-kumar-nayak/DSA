class Solution {
    // int n;
    // public int helper(int nums[],int idx,int dp[]){
    //     if(idx >=n-1){
    //         return 0;
    //     }
        
    //     if(dp[idx] != -1){
    //         return dp[idx];
    //     }
    //     int min=Integer.MAX_VALUE;
        
    //     for(int i=1;i<=nums[idx];i++){
    //         int result=helper(nums,idx+i,dp);

    //         if(result !=Integer.MAX_VALUE){
    //            min=Math.min(min,1+result);
    //         }
            
    //     }

    //     return dp[idx]=min;
    // }
    public int jump(int[] nums) {
    //     n=nums.length;
    //     int dp[]=new int[n];
    //     Arrays.fill(dp,-1);
    //   return  helper(nums,0,dp);
         int n=nums.length;
         int dp[]=new int[n];
         Arrays.fill(dp,Integer.MAX_VALUE);
         dp[n-1]=0;
         
         for(int idx=n-2;idx>=0;idx--){

            for(int i=1;i<=nums[idx] && idx+i <n;i++){
                
                if(dp[idx+i] !=Integer.MAX_VALUE){
                   dp[idx]=Math.min(dp[idx],1+dp[idx+i]);
                }
                
            }
         }

         return dp[0];

    }
}