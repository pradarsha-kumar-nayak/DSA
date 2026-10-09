class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int i=0;
        int ans=0;
        Stack<Character>st=new Stack<>();
        while(i <n){

            char ch=s.charAt(i);

            if(ch =='('){
               st.push(ch);
            }else{

                if(st.isEmpty()){
                  ans++;
                  
                  if(i+1 >=n || s.charAt(i+1) != ')'){
                    ans++;
                    i++;
                    continue;
                  }else{
                    i+=2;
                    continue;
                  }
                }

                st.pop();

                i++;
                if(i >=n ){
                    ans++;
                    break;
                }

                if(s.charAt(i) != ')'){
                    ans++;
                }else{
                    i++;
                }

                continue;
            }

            i++;
        }

        if(!st.isEmpty()){
            int extans=st.size()*2;

            ans+=extans;
        }

        return ans;
    }
}