/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer>cp=new ArrayList<>();
        int prev=head.val;
        ListNode temp=head.next;
        int idx=1;

        while(temp != null && temp.next !=null){

            if(temp.val <prev && temp.val < temp.next.val){
                cp.add(idx);
            }

            if(temp.val > prev && temp.val >temp.next.val){
                cp.add(idx);
            }

            prev=temp.val;
            temp=temp.next;
            idx++;
        }

        if(cp.size() <2){
            return new int[]{-1,-1};
        }

        int max=cp.get(cp.size()-1)-cp.get(0);

        int min=Integer.MAX_VALUE;

        for(int i=1;i<cp.size();i++){
            int val=cp.get(i)-cp.get(i-1);
            min=Math.min(min,val);
        }

        return new int[]{min,max};
    }
}