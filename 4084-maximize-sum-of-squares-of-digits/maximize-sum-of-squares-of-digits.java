class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb=new StringBuilder();
       while(num >0){
           
           if(sum ==0){
            sb.append("0");
            num--;
            continue;
           }

           if(sum >=10){
            sb.append("9");
            sum-=9;
            num--;
           }else{
            sb.append(sum);
            sum-=sum;
            num--;
           }
       }

       return (sum >0)?"":sb.toString();
    }
}