class Solution {
    public int numOfSubarrays(int[] arr) {
       int evncount=1;
       int oddcount=0;
       int ans=0;

       int sum=0;
       int mod=1000000007;

       for(int i=0;i<arr.length;i++){
          
          sum+=arr[i];

          if(sum %2 ==0){
             
             ans=(ans+oddcount)%mod;
             evncount++;
          }else{
            ans=(ans+evncount)%mod;
            oddcount++;
           
          }

       }

       return ans;
    }
}