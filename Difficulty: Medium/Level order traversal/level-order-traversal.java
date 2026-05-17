
class Solution {
    public ArrayList<Integer> levelOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            result.add(curr.data);
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
        return result;
    }
}