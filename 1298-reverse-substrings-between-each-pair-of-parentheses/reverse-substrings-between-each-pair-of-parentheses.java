class Solution {
    public String reverseParentheses(String s) {
        Stack<String>st=new Stack<>();
        StringBuilder sb=new StringBuilder();

        int i=0;

        while(i<s.length()){

            char ch=s.charAt(i);

            if(ch !='('){
                sb.append(ch);
                i++;
                continue;
            }

            if(ch == '('){
                st.push(ch +"");
                i++;

                while(!st.isEmpty()){

                    if(s.charAt(i) !=')'){
                        st.push(s.charAt(i)+"");
                        i++;
                        continue;
                    }

                    StringBuilder sb2=new StringBuilder();

                    while(!st.peek().equals("(")){
                        sb2.append(st.pop());
                    }

                    st.pop();
                    i++;
                    
                if(!st.isEmpty()){
                    int j=0;
                    while(j<sb2.length()){
                        st.push(sb2.charAt(j)+"" );
                        j++;
                    }
                  
                }else{
                    sb.append(sb2.toString());
                }
            }
        }
    }

    return sb.toString();
}
}