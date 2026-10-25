class Solution {
    public int solve(int num){

        String str=Integer.toString(num);

        char arr[]=str.toCharArray();

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){

                if(arr[j] <arr[j+1]){
                    char tmp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;

                }
            }
        }

        int modify=0;
        for(int i=0;i<arr.length;i++){

            int n=arr[i]-'0';
            modify=modify*10+n;
        }

        return modify-num;
    }
    public long maximizeSum(int[] nums, int k) {
        long ans=0;

        for(int i=0;i<nums.length;i++){
            ans+=nums[i];
        }

        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<nums.length;i++){
            int dif=solve(nums[i]);

            pq.add(dif);

        }

        while(k >0){
            int n=pq.remove();
            ans+=n;
            k--;
        }
        
        return ans;

    }
}