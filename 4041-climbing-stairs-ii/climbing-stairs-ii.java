class Solution {
    int len;
    public int solve(int i, int[] costs,int dp[]){
        if(i >len){
            return 10000000;
        }

        if(i == len){
           return 0;
        }

        if(dp[i] !=-1){
            return dp[i];
        }

    
           int fst=costs[i]+1*1+solve(i+1,costs,dp);
           
           int sec=10000000;
           if(i+2 <=len){
               sec=costs[i+1]+2*2+solve(i+2,costs,dp);
           }
           
           int trd=10000000;

           if(i+3 <= len){
                trd=costs[i+2]+3*3+solve(i+3,costs,dp);
           }
          
        return dp[i]= Math.min(fst,Math.min(sec,trd));

    }
    public int climbStairs(int n, int[] costs) {
        
        int dp[]=new int[n];

        Arrays.fill(dp,-1);

        len=n;
        return solve(0,costs,dp);
    }
}