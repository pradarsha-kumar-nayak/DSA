class Solution {
    public int minimumDeletions(int[] nums) {
        int minidx=0;
        int maxidx=0;
        int minval=Integer.MAX_VALUE;
        int maxval=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > maxval){
                maxval=nums[i];
                maxidx=i;
            }
            if(nums[i] < minval){
                minval=nums[i];
                minidx=i;
            }
        }
        
        int n=nums.length;

       
        int lftlrgidx=Math.max(minidx,maxidx)+1;

        int totallftside=lftlrgidx;
        
        int ritsmlidx=n-Math.min(minidx,maxidx);
        
        
        int totalritside=ritsmlidx;

        int lft=Math.min(minidx,maxidx)+1;
        int rit=n-Math.max(minidx,maxidx);

        int totalsep=lft+rit;

        int ans=Math.min(totallftside,Math.min(totalritside,totalsep));

       return ans;
    }
}