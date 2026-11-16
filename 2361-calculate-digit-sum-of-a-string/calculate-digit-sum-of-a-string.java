class Solution {
    public String digitSum(String s, int k) {
        String ans="";
        int n=s.length();
        ArrayList<Integer>ar=new ArrayList<>();
        
        if(s.length() <=k){
            for(int i=0;i<s.length();i++){
                ans+=s.charAt(i);
            }

            return ans;
        }

        for(int i=0;i<s.length();i+=k){

            int cursum=0;

            for(int j=i;j<Math.min(i+k,n);j++){
                cursum+=s.charAt(j)-'0';

            }

            String str=String.valueOf(cursum);
            for(int l=0;l<str.length();l++){
                ar.add(str.charAt(l)-'0');
            }
            
        }


        
        while(ar.size() >k){
            ArrayList<Integer>anslist=new ArrayList<>();
            
            for(int i=0;i<ar.size();i+=k){
            
            int cursum=0;

            for(int j=i;j<Math.min(i+k,ar.size());j++){
                cursum+=ar.get(j);

            }

            anslist.add(cursum);
           }

           ar.clear();

           
           for(int i=0;i<anslist.size();i++){
            String str=String.valueOf(anslist.get(i));
             for(int j=0;j<str.length();j++){
                ar.add(str.charAt(j)-'0');
             }
           }
          
     }

        

        if(ar.size() <=k){

            for(int i=0;i<ar.size();i++){
                ans+=ar.get(i);
            }
        }

        return ans;
    }
}