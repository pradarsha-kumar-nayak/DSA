class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        
       
        
        if(cost1+cost2 <= costBoth){
            long cst1=1l*cost1*need1;
            long cst2=1l*cost2*need2;

            return cst1+cst2;

        }


        int both=Math.min(need1,need2);

        long total=1l*both*costBoth;

        need1-=both;
        need2-=both;

        if(need1 >0){
            total+=1l*need1*Math.min(cost1,costBoth);
        }else if(need2 >0){
            total+=1l*need2*Math.min(cost2,costBoth);
        }

     return total;


    }
}

