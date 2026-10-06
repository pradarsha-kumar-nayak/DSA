/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer,TreeNode>hm;
    HashSet<Integer>vis;
    public void Addparent(TreeNode root){

        if(root ==null){
            return;
        }

        if(root.left !=null){
            hm.put(root.left.val,root);
        }

        Addparent(root.left);

        if(root.right !=null){
            hm.put(root.right.val,root);
        }

        Addparent(root.right);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        hm=new HashMap<>();
        vis=new HashSet<>();
        Addparent(root);
        int lev=0;
        List<Integer>ans=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();

        q.add(target);

        while(!q.isEmpty()){
            
            int siz=q.size();

            if(lev ==k){
                while(!q.isEmpty()){
                    TreeNode res=q.remove();
                    ans.add(res.val);
                }
                break;
            }
            for(int i=0;i<siz;i++){

                TreeNode cur=q.remove();
                vis.add(cur.val);

                if(cur.left !=null && !vis.contains(cur.left.val)){
                    q.add(cur.left);
                }
                if(cur.right !=null && !vis.contains(cur.right.val)){
                    q.add(cur.right);
                }

                if(hm.containsKey(cur.val) && !vis.contains(hm.get(cur.val).val)){
                    q.add(hm.get(cur.val));
                }

            }
            lev++;
        }

        return ans;
    }
}