class Solution {
    public int helper(String s,int lft,int rit,int k){

        while(lft>=0 && rit<s.length() &&s.charAt(lft) == s.charAt(rit) ){
            
            int klen=rit-lft+1;

            if(klen >=k){
                return klen;
            }

            lft--;
            rit++;

        }

        return -1;
    }
    public int maxPalindromes(String s, int k) {
        
        int ans=0;
        int lstprv=-1;

        for(int i=0;i<s.length();i++){

            int odd=helper(s,i,i,k);
            int evn=helper(s,i,i+1,k);

         if(odd >0){
            int fst=i-(odd-1)/2;
            int lst=i+odd/2;

            if(fst > lstprv){
                ans++;
                lstprv=lst;
            }

          
         }

          if(evn >0){
            int fst=i-(evn-1)/2;
            int lst=i+evn/2;

            if(fst > lstprv){
                ans++;
                lstprv=lst;
            }


         }

            
        }

        return ans;

    }
}