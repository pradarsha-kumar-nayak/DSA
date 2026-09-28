class Solution {
    public int maxDepth(String s) {
        int open=0;
        int maxdep=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
                maxdep=Math.max(open,maxdep);
            }else if(s.charAt(i)==')'){
                open--;
            }
        }
        return maxdep;
        
    }
}