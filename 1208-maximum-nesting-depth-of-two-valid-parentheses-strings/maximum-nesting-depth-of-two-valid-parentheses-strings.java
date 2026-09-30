class Solution {
    public int[] maxDepthAfterSplit(String seq) {
      int n=seq.length();
      int res[]=new int[n];
      int dep=0;

      for(int i=0;i<n;i++){
        char ch=seq.charAt(i);

        if(ch =='('){
            dep++;
            if(dep%2 !=0){
                res[i]=1;
            }else{
                res[i]=0;
            }
        }else{
           
           if(dep%2 !=0){
                res[i]=1;
            }else{
                res[i]=0;
            }

            dep--;
            
        }
      }
      return res;
    }
}