class Solution {
    public long minCost(int[] nums) {
        int n=nums.length;
        int prifix[]=new int[n];
        int sufix[]=new int[n];

        prifix[0]=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                prifix[i]=prifix[i-1]+1;
            }else{
                prifix[i]=1;
            }
        }

        sufix[n-1]=1;

        for(int i=n-2;i>=0;i--){
            if(nums[i] == nums[i+1]){
                sufix[i]=sufix[i+1]+1;
            }else{
                sufix[i]=1;
            }
        }

        long ans=Long.MAX_VALUE;

        for(int i=1;i<n-1;i++){
            
            //prifix
            int priExt=prifix[i]-1;

            int xtr=i-priExt;

            long prifixcost=(long)nums[i]*xtr;

            //sufix

            int sufExt=sufix[i]-1;
            int hlp=i+sufExt;

            int Sxtr=n-hlp-1;

            long sufixcost=(long)nums[i]*Sxtr;

            ans=Math.min(ans, prifixcost+sufixcost);


        }

        return ans;
    }
}