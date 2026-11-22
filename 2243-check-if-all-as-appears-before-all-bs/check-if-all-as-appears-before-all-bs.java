class Solution {
    public boolean checkString(String s) {
        boolean Bstart=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) =='b'){
                Bstart=true;
            }

            if(Bstart && s.charAt(i) =='a'){
                return false;
            }
        }

        return true;
    }
}