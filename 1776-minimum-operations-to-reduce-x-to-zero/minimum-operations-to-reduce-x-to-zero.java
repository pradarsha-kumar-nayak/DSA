class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int n=nums.length;
        hm.put(0,-1);
        int totalsum=0;
        for(int i=0;i<n;i++){
            totalsum+=nums[i];
            hm.put(totalsum,i);
        }

        int target=totalsum-x;

        int ans=-1;

        int sum=0;

        for(int i=0;i<n;i++){

            sum+=nums[i];
            int xtr=sum-target;
            if(sum >= target && hm.containsKey(xtr)){
                ans=Math.max(ans,i-hm.get(xtr));
            }
        }


        return (ans == -1)?-1:n-ans;
    }
}