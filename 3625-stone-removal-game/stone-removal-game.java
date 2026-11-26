class Solution {
    public boolean canAliceWin(int n) {
        
        char ply='A';
        int Aval=10;
        int Bval=9;

        while(true){

            if(ply == 'A'){
               if(n >=Aval){
                n-=Aval;
                Aval-=2;
               }else{
                return false;
               }
            }else{
                if(n>=Bval){
                    n-=Bval;
                    Bval-=2;
                }else{
                    return true;
                }
            }

            if(ply =='A'){
                ply='B';
            }else{
                ply='A';
            }
        }

        
    }
}