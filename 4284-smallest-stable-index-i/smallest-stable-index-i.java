class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int prifix[]=new int[nums.length];
        int sufix[]=new int[nums.length];

        //prefix maximum
        prifix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prifix[i]=Math.max(nums[i],prifix[i-1]);
        }

        //sufix minimum

        sufix[nums.length-1]=nums[nums.length-1];

        for(int i=nums.length-2;i>=0;i--){
            sufix[i]=Math.min(nums[i],sufix[i+1]);
        }

        int j=0;

        while(j<nums.length){
            if(prifix[j] - sufix[j] <= k){
                return j;
            }
            j++;
        }

        return -1;
    }
}