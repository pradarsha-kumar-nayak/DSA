class Solution {
    int maxlen=Integer.MIN_VALUE;
    HashSet<String>hs=new HashSet<>();
    public void solve(int i,String cur,int count,String s){
        if(i == s.length()){

            if(count == 0){
                maxlen=Math.max(maxlen,cur.length());
                hs.add(cur);
            }
            return;
        }

        char ch=s.charAt(i);
        if(ch == '('){
            count++;
            solve(i+1,cur+ch,count,s);
            count--;
            solve(i+1,cur,count,s);
        }else if(ch == ')'){
            if(count >0){
                count--;
                solve(i+1,cur+ch,count,s);
                count++;
            }
            solve(i+1,cur,count,s);
        }else{
       
            solve(i+1,cur+ch,count,s);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        solve(0,"",0,s);

        List<String>ans=new ArrayList<>();

        for(String str : hs){

            if(str.length() == maxlen){
                ans.add(str);
            }
        }
        if(ans.size() ==0){
            String str="";
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(ch !='(' && ch !=')'){
                  str+=ch;
                }
            }
             ans.add(str);
        }
       
        return ans;
    }
}