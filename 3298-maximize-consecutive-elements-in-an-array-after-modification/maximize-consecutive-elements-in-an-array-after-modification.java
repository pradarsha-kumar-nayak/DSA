class Solution {

    public int findnext(int i,int tar,int nums[]){

        int st=i;
        int end=nums.length-1;
        int ans=-1;

        while(st <= end){
            int mid=(st+end)/2;

            if(nums[mid] == tar){
                ans=mid;
                end=mid-1;
            }
            else if(nums[mid] >tar){
                end=mid-1;
            }else{
                st=mid+1;
            }
        }

        return ans;
    }
    public int solve(int i, int inc,int[] nums,int dp[][]){

        int curval=nums[i]+inc;
        
        if(dp[i][inc] !=-1){
            return dp[i][inc];
        }

        int maxcon=1;

        int idx1=findnext(i+1,curval,nums);

        if(idx1 != -1){
            maxcon=Math.max(maxcon,1+solve(idx1,1,nums,dp));
        }

        int idx2=findnext(i+1,curval+1,nums);

        if(idx2 != -1){
            maxcon=Math.max(maxcon,1+solve(idx2,0,nums,dp));
        }

        return dp[i][inc]=maxcon;
        
    }
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        int dp[][]=new int[nums.length][2];

        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int result=1;
        for(int i=0;i<nums.length;i++){
            
            int addone=solve(i,1,nums,dp);
            int skipone=solve(i,0,nums,dp);

            int add_skip_max=Math.max(addone,skipone);

            result=Math.max(result,add_skip_max);
        }

        return result;

    }
}

