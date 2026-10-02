class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer>dq=new LinkedList<>();
        dq.add(0);

        for(int i=1;i<nums.length;i++){

            if(dq.peekFirst()+k < i){
                dq.removeFirst();
            }
            nums[i]=nums[dq.peekFirst()]+nums[i];

            while(!dq.isEmpty()&& nums[dq.peekLast()] <=nums[i]){
                dq.removeLast();
            }

            dq.addLast(i);
        }

        return nums[nums.length-1];
    }
}