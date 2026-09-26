class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        HashMap<String,String>hm=new HashMap<>();

        for(int i=0;i<knowledge.size();i++){
          List<String>li=knowledge.get(i);
          hm.put(li.get(0),li.get(1));
        }

        int k=0;

        StringBuilder sb=new StringBuilder();
        while(k <s.length()){
              
              if(s.charAt(k) != '('){
                sb.append(s.charAt(k));
                k++;
                continue;
              }
              
              StringBuilder sb2=new StringBuilder();
              if(s.charAt(k) == '('){
                 k++;
                while(s.charAt(k) !=')'){
                  sb2.append(s.charAt(k));
                  k++;
                }
              }
              k++;
              
              if(hm.containsKey(sb2.toString())){
                sb.append(hm.get(sb2.toString()));
              }else{
                sb.append('?');
              }
              
        }

        return sb.toString();
    }
}