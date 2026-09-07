class Solution {
    public int distinctSubseqII(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        dp[0]=1;
        int mod=1000000007;
        HashMap<Character,Integer>lo=new HashMap<>();

        for(int i=1;i<n+1;i++){

            dp[i]=(dp[i-1]*2)%mod;
            char ch=s.charAt(i-1);

            if(lo.containsKey(ch)){
                int po=lo.get(ch);
                dp[i]=(dp[i]-dp[po-1]+mod)%mod;
            }

            lo.put(ch,i);
        }

        return (dp[n]-1+mod)%mod;
    }
}