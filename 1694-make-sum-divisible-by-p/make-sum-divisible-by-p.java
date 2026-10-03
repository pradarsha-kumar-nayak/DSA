class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalsum=0;

        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];
        }

        int tar=(int)(totalsum%p);

        if(tar ==0){
            return 0;
        }

        if(totalsum <p){
            return -1;
        }

       HashMap<Integer,Integer>hm=new HashMap<>();
       hm.put(0,-1);
        int minlen=Integer.MAX_VALUE;
        long sum=0;
        for(int i=0;i<nums.length;i++){

           sum+=nums[i];

           int cur=(int)(sum%p);
           
           int val=(cur-tar+p)%p;
           if(hm.containsKey(val)){
             int lft=hm.get(val);
             minlen=Math.min(minlen,i-lft);
           }

           hm.put(cur,i);
        }

        return minlen== nums.length || minlen==Integer.MAX_VALUE?-1:minlen;
    }
}