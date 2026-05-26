class BrowserHistory {
    class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage); 
    }
    
    public void visit(String url) {
        Node temp = new Node(url);
        curr.next = temp;
        temp.prev = curr;
        curr = temp; 
    }
    
    public String back(int steps) {
        while ((steps > 0) && (curr.prev != null)) {
            curr = curr.prev;
            steps--;
        }
        return curr.data;
    }
    
    public String forward(int steps) {
        while ((steps > 0) && (curr.next != null)) {
            curr = curr.next;
            steps--;
        }
        return curr.data;
    }
}
