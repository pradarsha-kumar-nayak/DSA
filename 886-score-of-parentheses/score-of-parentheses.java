class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Character>st=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='('){
                st.push(ch);
            }else{
                if(st.peek()=='('){
                    st.pop();
                    st.push('1');
                }else{
                    int count=0;
                    while(st.peek() !='('){
                        char num=st.pop();
                        count+=num-'0';
                    }

                    st.pop();
                    int n=count*2;
                    st.push((char)('0'+n));
                }
            }
        }

        int ans=0;

        while(!st.isEmpty()){
            ans+=st.pop()-'0';
        }

        return ans;
    }
}