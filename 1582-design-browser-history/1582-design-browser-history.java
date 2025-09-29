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

    private Node curr; // keep track of the current page

    public BrowserHistory(String homepage) {
        curr = new Node(homepage); // initialize current with homepage
    }
    
    public void visit(String url) {
        Node temp = new Node(url);
        curr.next = temp;
        temp.prev = curr;
        curr = temp; // move current to new page
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
            curr = curr.next; // ✅ correct way to move forward
            steps--;
        }
        return curr.data;
    }
}
