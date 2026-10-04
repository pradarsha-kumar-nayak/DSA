class Solution {
    public boolean checkValidString(String s) {
        int open=0;
        int close=0;
        int star=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='('){
                open++;
            }else if(ch == ')'){
                close++;
            }else{
                star++;
            }

            if(close >open && star ==0){
                return false;
            }

            if(close >open){
                open++;
                star--;
            }
        }
        
        open=0;
        close=0;
        star=0;
        
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);

            if(ch=='('){
                open++;
            }else if(ch == ')'){
                close++;
            }else{
                star++;
            }

            if(open >close && star ==0){
                return false;
            }

            if(open >close){
                close++;
                star--;
            }
        }

        return true;
    }
}