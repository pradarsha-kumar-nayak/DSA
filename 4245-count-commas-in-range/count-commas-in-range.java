class Solution {
    public int countCommas(int n) {
        if(n <1000){
            return 0;
        }
       int total=0;
       for(int i=1;i<=n;i++){
           int digit=String.valueOf(i).length();
           total+=(digit-1)/3;
       }
        return total;
    }
}