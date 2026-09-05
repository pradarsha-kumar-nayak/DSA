class Solution {
    public int lowerbound(int[][] fruits,int tar){
        int lft=0;
        int rit=fruits.length-1;

        while(lft < rit){
            int mid=(lft+rit)/2;

            if(fruits[mid][0] >=tar){
                rit=mid;
            }else{
                lft=mid+1;
            }
        }

           if(fruits[lft][0] < tar){
             return fruits.length;
           }

        return lft;
    }
    public int upperbound(int[][] fruits,int tar){
        int lft=0;
        int rit=fruits.length-1;

        while(lft < rit){
            int mid=(lft+rit+1)/2;

            if(fruits[mid][0] <=tar){
                lft=mid;
            }else{
                rit=mid-1;
            }
        }

        if(fruits[lft][0] >tar){
            return -1;
        }

        return lft;
    }
    public int maxTotalFruits(int[][] fruits, int p, int k) {
       
       

        int n=fruits.length;
        int maxhar=Integer.MIN_VALUE;
        int prifixsum[]=new int[n];

        prifixsum[0]=fruits[0][1];

        for(int i=1;i<n;i++){
           prifixsum[i]=prifixsum[i-1]+fruits[i][1];
        }

        for(int d=0;d<=k;d++){

            int lft=p-d;
            int rit=p+ (k-2*d);

            int lb=lowerbound(fruits,lft);
            int up=upperbound(fruits,rit);

            if(up < lb){
                continue;
            }
            
            int totalhar=0;
            if(lb ==0){
               totalhar=prifixsum[up];
            }else{
               totalhar=prifixsum[up]-prifixsum[lb-1];
            }

            maxhar=Math.max(totalhar,maxhar);


        }

         for(int d=0;d<=k;d++){

            int rit=p+d;
            int lft=p-(k-2*d);

            int lb=lowerbound(fruits,lft);
            int up=upperbound(fruits,rit);

            if(up < lb){
                continue;
            }
            
            int totalhar=0;
            if(lb ==0){
               totalhar=prifixsum[up];
            }else{
               totalhar=prifixsum[up]-prifixsum[lb-1];
            }

            maxhar=Math.max(totalhar,maxhar);


        }

        return (maxhar==Integer.MIN_VALUE)?0:maxhar;
    }
}