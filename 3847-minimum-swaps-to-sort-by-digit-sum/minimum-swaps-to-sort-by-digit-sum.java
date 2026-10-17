class Solution {
    class hlp{
        int dgsm;
        int ele;

        public hlp(int dgsm,int ele){
            this.dgsm=dgsm;
            this.ele=ele;
        }
    }
    public int minSwaps(int[] nums) {
        
        HashMap<Integer,Integer>hm=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }

        hlp dgtsum[]=new hlp[nums.length];

        for(int i=0;i<nums.length;i++){

            int sum=0;
            int digit=nums[i];

            while(digit !=0){
                sum+=digit%10;

                digit=digit/10;
            }

            dgtsum[i]=new hlp(sum,nums[i]);
        }

         Arrays.sort(dgtsum,(a,b)->{
            if(a.dgsm != b.dgsm){
                return Integer.compare(a.dgsm,b.dgsm);
            }else{
                return Integer.compare(a.ele,b.ele);
            }
        });

        int ans=0;

        for(int i=0;i<nums.length;i++){

            if(nums[i] != dgtsum[i].ele){
                ans++;
                int coridx=hm.get(dgtsum[i].ele);
                hm.put(nums[i],coridx);
                int tmp=nums[i];
                nums[i]=nums[coridx];
                nums[coridx]=tmp;

            }
        }


        return ans;

    }
}