class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        int sqrcpy[]=new int[n];

        for(int i=0;i<n;i++){
            sqrcpy[i]=nums[i]*nums[i];
        }

        Arrays.sort(sqrcpy);

        int mid=n/2;

        long max=0;
        long min=0;

        for(int i=0;i<mid;i++){
            min+=sqrcpy[i];
        }

        for(int i=mid;i<n;i++){
            max+=sqrcpy[i];
        }

        return max-min;

    }
}