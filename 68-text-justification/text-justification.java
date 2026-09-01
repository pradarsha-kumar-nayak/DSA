class Solution {
    public String helper(int fst,int lst,int divgadha,int extragadha,String words[], int maxWidth){
        
        String str="";
        for(int i=fst;i<lst;i++){
           
           str+=words[i];
        if(i != lst-1){ 
           for(int j=0;j<divgadha;j++){
            str+=" ";
           }

           if(extragadha >0){
            str+=" ";
            extragadha--;
           }
         }
        }

        while(str.length() <maxWidth){
            str+=" ";
        }

        return str;

    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String>ans=new ArrayList<>();
        int n=words.length;
        int i=0;

        while(i < n){
            int j=i+1;
            int wordcount=0;
            wordcount+=words[i].length();
            int gadha=0;

            while(j < n && words[j].length()+gadha+wordcount+1 <=maxWidth){
                gadha++;
                wordcount+=words[j].length();
                j++;
            }

            int remaninggadha=maxWidth - wordcount;
            int divgadha=(gadha ==0)?0:remaninggadha/gadha;
            int extragadha=(gadha ==0)?0:remaninggadha%gadha;

            if(j == n){
                divgadha=1;
                extragadha=0;
            }
            
            ans.add(helper(i,j,divgadha,extragadha,words,maxWidth));
            
            i=j;
        }

        return ans;
    }
}