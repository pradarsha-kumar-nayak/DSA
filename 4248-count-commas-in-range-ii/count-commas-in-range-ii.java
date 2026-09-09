class Solution {
    public long countCommas(long n) {
       long res=0;
       long lower=1000;
       int comma=1;
       while(lower <=n ){
        long upper=lower*1000-1;

        if(upper >n){
            upper=n;
        }

        long diff=upper - lower+1;

        res+=(diff*comma);

        lower=lower*1000;
        comma++;

       }

       return res;
    }
}