class Solution {
     public int binarysch(int st,int end,int tar,int[][] intervals){
        int fstst=st;
        while(st <= end){

            int mid=(st+end)/2;;

            if(intervals[mid][0] <= tar){
               st=mid+1;
            }else{
                end=mid-1;
            }
        }

        return st-fstst;
    }
    public long countIntersectingIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int intervalcnt[]=new int[n];
        long ans=0;
        for(int i=0;i<n-1;i++){

            ans+=binarysch(i+1,n-1,intervals[i][1],intervals);
        }

        return ans;
    }
}