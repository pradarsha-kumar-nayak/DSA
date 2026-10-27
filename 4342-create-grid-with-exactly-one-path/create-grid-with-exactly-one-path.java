class Solution {
    public String[] createGrid(int m, int n) {
        
        String ans[]=new String[m];

        for(int i=0;i<m-1;i++){

            String str=".";

            for(int j=1;j<n;j++){
                str+="#";
            }
            ans[i]=str;
        }
        
        String str="";

        for(int j=0;j<n;j++){
                str+=".";
            }

        ans[m-1]=str;

        return ans;
        
    }
}