class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        HashMap<Integer,ArrayList<Integer>>hm=new HashMap<>();

        ArrayList<Integer>list=new ArrayList<>();

        int copy[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            copy[i]=nums[i];
        }

        Arrays.sort(copy);

        list.add(copy[0]);
        hm.put(copy[0],list);

        for(int i=1;i<nums.length;i++){

            if(copy[i]-copy[i-1] <= limit){
                ArrayList<Integer>li=hm.get(copy[i-1]);
                li.add(copy[i]);
                hm.put(copy[i],li);
            }else{
                list=new ArrayList<>();
                list.add(copy[i]);
                hm.put(copy[i],list);
            }
        }

        int ans[]=new int[nums.length];

        for(int i=0;i<nums.length;i++){
             ArrayList<Integer>li=hm.get(nums[i]);
             ans[i]=li.get(0);
             li.remove(0);
        }

        return ans;
    }
}