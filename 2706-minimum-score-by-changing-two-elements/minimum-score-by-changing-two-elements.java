class Solution {
    public int minimizeSum(int[] nums) {
        if(nums.length == 3){
            return 0;
        }

        int n=nums.length;

        Arrays.sort(nums);

        int minans=Integer.MAX_VALUE;

        minans=Math.min(minans,nums[n-2]-nums[1]);

        minans=Math.min(minans,nums[n-3]-nums[0]);

        minans=Math.min(minans,nums[n-1]-nums[2]);


        return minans;

    }
}