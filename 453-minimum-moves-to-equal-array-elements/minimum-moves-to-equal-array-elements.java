class Solution {
    public int minMoves(int[] nums) {
        
       

        int minval=Integer.MAX_VALUE;
        // int maxval=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            
            // maxval=Math.max(maxval,nums[i]);
            minval=Math.min(minval,nums[i]);

        }
        
        int ans=0;
        for(int i=0;i<nums.length;i++){

           
                ans+=nums[i]-minval;
            
        }

     return ans;

    }
}