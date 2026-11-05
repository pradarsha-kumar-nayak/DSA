class Solution {
    class node{
        int ele;
        int poi;

        public node(int ele,int poi){
            this.ele=ele;
            this.poi=poi;
        }
    }
    long cost[];
    public boolean remove(TreeSet<node>ts,int e,int poi){

        boolean find=false;

        if(ts.contains(new node(e,poi))){
            ts.remove(new node(e,poi));
            find =true;
        }
        return find;
    }
    public void findcost(int[] nums, int x){
       TreeSet<node>lftts=new TreeSet<>((a,b)->{

         int com=Integer.compare(b.ele,a.ele);

         if(com == 0){
            com=Integer.compare(a.poi,b.poi);
         }

         return com;

       });

       TreeSet<node>ritts=new TreeSet<>((a,b)->{
         
         int com=Integer.compare(a.ele,b.ele);

         if(com == 0){
            com=Integer.compare(b.poi,a.poi);
         }

         return com;

       });

       int j=0;
       int p=1;
       long lftsum=0;
       long ritsum=0;

       for(int i=0;i<nums.length;i++){

         if(lftts.size() <= ritts.size()){
            lftts.add(new node(nums[i],p));
            lftsum+=nums[i];

         }else{
            ritts.add(new node(nums[i],p));
            ritsum+=nums[i];
         }

         if(!lftts.isEmpty() && !ritts.isEmpty() && lftts.first().ele > ritts.first().ele){
            node lftcur=lftts.first();
            node ritcur=ritts.first();
            lftts.remove(lftcur);
            ritts.remove(ritcur);
            lftts.add(new node(ritcur.ele,ritcur.poi));
            ritts.add(new node(lftcur.ele,lftcur.poi));

            lftsum-=lftcur.ele;
            ritsum-=ritcur.ele;

            lftsum+=ritcur.ele;
            ritsum+=lftcur.ele;
            
         }

         if(i-j+1 == x){
           
            int mid=lftts.first().ele;
            
            long lftlen=(lftts.size())*mid;
            long ritlen=ritts.size()*mid;

            long lftans=Math.abs(lftlen-lftsum);
            long ritans=Math.abs(ritlen-ritsum);

            cost[j]=lftans+ritans;
            
            if(!remove(lftts,nums[j],j+1)){
                remove(ritts,nums[j],j+1);
                ritsum-=nums[j];
            }else{
                lftsum-=nums[j];
            }

            j++;
         }

         p++;
       }

    }
    public long solve(int[] nums, int x, int k,int idx,long dp[][]){
        if(k==0){
            return 0;
        }

        if(dp[idx][k] !=-1){
            return dp[idx][k];
        }

        int remain=x*k;
        int extraele=nums.length-idx;

        if(extraele <remain){
            return Long.MAX_VALUE/4;
        }

        long keep=cost[idx]+solve(nums,x,k-1,idx+x,dp);
        long skip=solve(nums,x,k,idx+1,dp);

        return dp[idx][k]= Math.min(keep,skip);
    }
    public long minOperations(int[] nums, int x, int k) {
        cost=new long[nums.length];

        findcost(nums,x);

        long dp[][]=new long[nums.length+1][k+1];

        for(int i=0;i<nums.length+1;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(nums,x,k,0,dp);

    }
}