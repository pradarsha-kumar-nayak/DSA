class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int count=1;
       

        for(int i=1;i<nums.length;i++){
           
           if(nums[i] > nums[i-1]){
             count++;
             ans=Math.max(ans,count);
           }else{
             count=1;
           }
        }

        count=1;

        for(int i=1;i<nums.length;i++){
           
           if(nums[i] < nums[i-1]){
             count++;
             ans=Math.max(ans,count);
           }else{
             count=1;
           }
        }

        return (ans==Integer.MIN_VALUE)?1:ans;
    }
}