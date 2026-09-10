/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class hlp{
        int sum;
        int count;

        public hlp(int sum,int count){
            this.sum=sum;
            this.count=count;
        }
    }
    
    int anscount;
    public hlp helper(TreeNode root){
        if(root == null){
            return new hlp(0,0);
        }

        hlp lft= helper(root.left);
        hlp rit= helper(root.right);
         
        int nodecnt=lft.count+rit.count+1;
        int totalsum=lft.sum+rit.sum+root.val;
        int avg=totalsum/nodecnt;

        if(avg == root.val){
            anscount++;
        }

        return new hlp(totalsum,nodecnt);
    }
    public int averageOfSubtree(TreeNode root) {
        anscount=0;

        helper(root);

        return anscount;
    }
}