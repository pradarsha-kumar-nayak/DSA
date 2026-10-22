class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        
        int maxele=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            maxele=Math.max(nums[i],maxele);
        }

        int frqsum[]=new int[maxele+k+1];

        for(int i=0;i<nums.length;i++){
            frqsum[nums[i]]++;
        }

        for(int i=1;i<=maxele+k;i++){
            frqsum[i]+=frqsum[i-1];
        }

        int maxres=Integer.MIN_VALUE;
        for(int i=1;i<=maxele;i++){
            
            int lft=i-k;
            int rit=i+k;

            int totalcount=0;

            if(lft <=0){
                totalcount=frqsum[rit];
            }else{
                totalcount=frqsum[rit]-frqsum[lft-1];
            }

            int tarfrq=frqsum[i]-frqsum[i-1];
            
            int extrele=totalcount-tarfrq;

            int minope=Math.min(extrele,numOperations);

            int res=tarfrq+minope;

            maxres=Math.max(res,maxres);
        }
        
       return maxres;
    }
}