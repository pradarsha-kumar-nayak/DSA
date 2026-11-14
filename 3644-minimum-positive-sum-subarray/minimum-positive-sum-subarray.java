class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        
        int ans=Integer.MAX_VALUE;
        int n=nums.size();
        

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums.get(j);

                if(sum >0 && j-i+1 >=l && j-i+1 <=r){
                    ans=Math.min(sum,ans);
                }
            }
        }

        return (ans==Integer.MAX_VALUE)?-1:ans;
    }
}