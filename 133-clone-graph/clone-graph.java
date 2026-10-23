/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void Dfs(Node node,Node clon_node, HashMap<Integer,Node> hm){

        for(int i=0;i<node.neighbors.size();i++){
            Node n=node.neighbors.get(i);

            if(!hm.containsKey(n.val)){
                Node clon=new Node(n.val);
                hm.put(n.val,clon);
                clon_node.neighbors.add(clon);
                Dfs(n,clon,hm);
            }else{
                clon_node.neighbors.add(hm.get(n.val));
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Integer,Node> hm=new HashMap<>();
       Node clon_node=new Node(node.val);

       hm.put(node.val,clon_node);

       Dfs(node,clon_node,hm);

       return clon_node;

    }
}