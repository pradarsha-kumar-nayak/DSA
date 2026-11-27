class Solution {
    int free[];
    int mincst=Integer.MAX_VALUE;
    int dp[][];
    public int solve(int[][] items, int budget,int i){
        if(budget==0){
           return 0;
        }

        if(i==0){
            return budget/mincst;
        }

        if(dp[i][budget] !=-1){
            return dp[i][budget];
        }

        int cost=items[i-1][1];

        if(cost <=budget){

            int add=1+free[i-1]+solve(items,budget-cost,i-1);

            int skip=solve(items,budget,i-1);

            return dp[i][budget]=Math.max(add,skip);
        }else{
            return dp[i][budget]=solve(items,budget,i-1);
        }
    }
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        for(int i=0;i<n;i++){
            mincst=Math.min(mincst,items[i][1]);
        }

        dp=new int[n+1][budget+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        free=new int[n];

        for(int i=0;i<n;i++){

            int fact=items[i][0];
            int count=0;

            for(int j=0;j<n;j++){

                if(j==i)continue;
      
                if(items[j][0]%fact ==0){
                    count++;
                }

            }

            free[i]=count;
        }

        return solve(items,budget,n);

    }
}