class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>dq=new LinkedList<>();
        ArrayList<Integer>ar=new ArrayList<>();
        for(int i=0;i<k;i++){
            while(dq.size() >0 && nums[dq.getLast()] <=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        for(int i=k;i<nums.length;i++){
            ar.add(nums[dq.getFirst()]);

            if(dq.getFirst() == (i-k)){
                dq.removeFirst();
            }

            while(dq.size() >0 && nums[dq.getLast()] <=nums[i]){
                dq.removeLast();
            }
             dq.addLast(i);
        }
         ar.add(nums[dq.getFirst()]);

         //asign arraylist to arr
         int arr[]=new int[ar.size()];
         for(int i=0;i<arr.length;i++){
            arr[i]=ar.get(i);
         }
         return arr;

        
    }
}