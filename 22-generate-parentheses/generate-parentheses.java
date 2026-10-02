class Solution {
    public boolean isCount(String str){
        int count=0;
        char arr[]=str.toCharArray();

        for(int i=0;i<arr.length;i++){
            char ch=arr[i];
            if(ch=='('){
                count++;
            }else{
                count--;
            }
            if(count <0){
              return false;
         }
        }
        
        return count==0;

    }
    public void helper( String str,List<String> li,int n){
        if(str.length()==2*n){
            if(isCount(str)){
                li.add(str);
            }
            return;
        }
        helper(str+"(",li,n);
        helper(str+")",li,n);

    }
    public List<String> generateParenthesis(int n) {
        List<String>li =new ArrayList<>();
        helper("",li,n);

        return li;
    }
}