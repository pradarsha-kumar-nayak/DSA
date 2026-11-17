class Solution {
    
    public int getcost(String str){
        int n=str.length();
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(n%i !=0) continue;

            int count=0;

            for(int j=0;j<i;j++){

                int st=j;
                int end=n-i+j;

                while(st <= end){
                  
                  if(str.charAt(st) != str.charAt(end)){
                    count++;
                  }

                  st+=i;
                  end-=i;
                }
            }

            min=Math.min(min,count);
        }
        return min;
    }
    public int solve(int st,String str, int k,int dp[][]){
        if(k==0){
            if(st== str.length()) return 0;

            return Integer.MAX_VALUE;
        }

        if(st + 2*k >str.length()){
            return Integer.MAX_VALUE;
        }

        if(dp[st][k] !=-1){
            return dp[st][k];
        }

        int result=Integer.MAX_VALUE;

        for(int end=st+1;end <str.length();end++){
            
            int remain=solve(end+1,str,k-1,dp);

            if(remain == Integer.MAX_VALUE){
                continue;
            }

             result= Math.min(result,getcost(str.substring(st,end+1))+remain);

        }

        return dp[st][k]=result;
    }
    public int minimumChanges(String s, int k) {

     int dp[][]=new int[s.length()][k+1];

     for(int i=0;i<dp.length;i++){
        Arrays.fill(dp[i],-1);
     }

     return  solve(0,s,k,dp);
        
    }
}