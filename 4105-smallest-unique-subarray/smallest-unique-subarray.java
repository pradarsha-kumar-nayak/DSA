class Solution {
    public boolean solve(int nums[],int size,int base){
         HashMap<Long,Integer>hm=new HashMap<>();   // CHANGE: Integer -> Long
        int MOD=1000000007;                   // CHANGE: new line
        long hash=0;                               // CHANGE: int -> long

        long p=1;                                  // CHANGE: Math.pow((int) cast) hata ke loop + mod
        for(int j=0;j<size-1;j++){                 // CHANGE
            p=(p*base)%MOD;                        // CHANGE
        }

        int lft=0;

        for(int i=0;i<nums.length;i++){

            hash=(hash*base+nums[i])%MOD;          // CHANGE: % MOD add kiya

            if(i-lft+1 ==size){
                hm.put(hash,hm.getOrDefault(hash,0)+1);
                hash=(hash-(nums[lft]*p)%MOD+MOD)%MOD;   // CHANGE: mod ke saath subtract
                lft++;
            }
        }

        for(long K:hm.keySet()){                   // CHANGE: int -> long
            if(hm.get(K) ==1){
                return true;
            }
        }

        return false;
    }
    public int smallestUniqueSubarray(int[] nums) {
        int base=0;
        for(int i=0;i<nums.length;i++){
            base=Math.max(base,nums[i]);
        }

        int lft=1;
        int rit=nums.length;

        while(lft <= rit){

            int mid=(lft+rit)/2;

            if(solve(nums,mid,base+1)){
                rit=mid-1;
            }else{
                lft=mid+1;
            }


        }

        return lft;
        
    }
}