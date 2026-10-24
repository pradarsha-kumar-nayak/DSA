class Solution {
    
    int mod=1000000007;
    int memo[][][]=new int[100001][3][2];
    public int solve(int p,int l,int a,int n){

        if(n==0){
            if(l <3 && a <2){
                return 1;
            }
            return 0;
        }

        if(l >= 3 || a>1){
            return 0;
        }

        if(memo[n][l][a] !=-1){
            return memo[n][l][a];
        }

       int P= solve(p+1,0,a,n-1);
       int L= solve(p,l+1,a,n-1);
       int A= solve(p,0,a+1,n-1);

       return memo[n][l][a]=((P+L)%mod +A)%mod;
      
    }
    public int checkRecord(int n) {

        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        
        return solve(0,0,0,n);
    }
}