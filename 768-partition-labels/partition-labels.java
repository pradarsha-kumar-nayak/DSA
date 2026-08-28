class Solution {
    public List<Integer> partitionLabels(String s) {
        int lstidx[]=new int[26];

        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            lstidx[idx]=i;
        }

        ArrayList<Integer>ans=new ArrayList<>();

        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            int maxlst=lstidx[idx];

            for(int j=i;j<maxlst;j++){
                int indx=s.charAt(j)-'a';
                maxlst=Math.max(lstidx[indx],maxlst);
            }
            int res=maxlst-i+1;
            ans.add(res);
            i=maxlst;
        }

        return ans;
    }
}