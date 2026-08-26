class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left=0;
        int minlen=Integer.MAX_VALUE;
        String ans="";
        int one=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                one++;
            }

            while(one >= k){

                if(minlen > i-left+1 ){
                    ans=s.substring(left,i+1);
                    minlen=ans.length();
                }else if(minlen == i-left+1){
                    String smlen=s.substring(left,i+1);

                    if(smlen.compareTo(ans)  <0){
                        ans=smlen;
                    }
                }

                if(s.charAt(left) == '1'){
                    one--;
                }
                left++;
            }
        }

        return ans;
    }
}