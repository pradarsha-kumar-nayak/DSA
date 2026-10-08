class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        int x=1;
        String s1="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }else{
                count--;
            }
            if(count ==0){
                s1=s1+s.substring(x,i);
                x=i+2;
            }
           
        }
        return s1;
        
    }
}