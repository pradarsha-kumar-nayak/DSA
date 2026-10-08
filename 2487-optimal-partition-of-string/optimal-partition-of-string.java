class Solution {
    public int partitionString(String s) {
        int ans=1;
        int lft=0;
        HashSet<Character>hs=new HashSet<>();
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch == s.charAt(lft) || hs.contains(ch)){
                ans++;
                lft=i;
                hs.clear();
            }else{
                hs.add(ch);
            }
        }

        return ans;
    }
}