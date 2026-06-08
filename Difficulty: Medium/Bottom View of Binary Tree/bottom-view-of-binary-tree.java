// Assuming your Pair class looks something like this:
class Pair {
    int dist;
    Node node;
    Pair(int dist, Node node) {
        this.dist = dist;
        this.node = node;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0, root));
        
        while (!q.isEmpty()) {
            Pair curr = q.remove();
            
            int hd = curr.dist;
            
            Node currNode = curr.node;
            
            tm.put(hd, currNode.data);
            
            if (currNode.left != null) {
                q.add(new Pair(hd - 1, currNode.left));
            }
            
            if (currNode.right != null) {
                q.add(new Pair(hd + 1, currNode.right));
            }
        }
        for (int value : tm.values()) {
            result.add(value);
        }
        
        return result;
    }
}