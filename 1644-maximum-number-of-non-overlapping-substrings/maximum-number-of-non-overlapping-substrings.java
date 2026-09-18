class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String>ans=new ArrayList<>();
        int fstidx[]=new int[26];
        int lstidx[]=new int[26];
        boolean validfstidx[]=new boolean[26];

        Arrays.fill(fstidx,-1);
        Arrays.fill(lstidx,-1);
        Arrays.fill(validfstidx,true);

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(fstidx[ch-'a'] ==-1){
               fstidx[ch-'a']=i;
            }
            lstidx[ch-'a']=i;
        }

        for(int i=0;i<26;i++){
            if(fstidx[i] ==-1) continue;

            for(int j=fstidx[i];j<=lstidx[i];j++){

                char ch=s.charAt(j);

                if(fstidx[ch-'a'] < fstidx[i]){
                    validfstidx[i]=false;
                    break;
                }

                lstidx[i]=Math.max(lstidx[ch-'a'],lstidx[i]);
                
            }
        }


        int prevfstpoint=Integer.MAX_VALUE;

        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);

            if(fstidx[ch-'a'] ==i && validfstidx[ch-'a'] && lstidx[ch-'a']<prevfstpoint){
                ans.add(s.substring(fstidx[ch-'a'],lstidx[ch-'a']+1));
                prevfstpoint=fstidx[ch-'a'];
            }
        }

     return ans;
    }
}