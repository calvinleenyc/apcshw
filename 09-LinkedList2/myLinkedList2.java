public class myLinkedList2 {
    private Node head;
    private int length;
    private Node tail;
    public myLinkedList2() {
	head = new Node(null);
	//data is null, not the node itself.
	length = 0;
	tail = head;
    }

    public String toString() {
	String ans = "[";
	Node temp = head.getNext();
	if (temp == null) {
	    return ans + "]";
	}
	ans += temp;
	while (temp.getNext() != null) {
	    temp = temp.getNext();
	    ans += ", ";
	    ans += temp;
	}

	ans += "]";
	return ans;
    }

    public void addToFront(String s) {
	Node temp = new Node(s);
	temp.setNext(head.getNext());
	head.setNext(temp);
	length++;
    }

    public void add(int pos, String s) {
	if(pos == length){
	    addToEnd(s);
	    return;
	}
	Node n1 = head;
	Node n2 = null;
	for(int i=0;i<=pos;i++){
	    n2 = n1;
	    n1 = n2.getNext();
	}
	Node temp = new Node(s);
	temp.setNext(n1);
	n2.setNext(temp);
	length++;
    }

    public int length() {
	return length;
    }

    public String get(int pos) {
	Node n = head;
	for (int i = 0; i <= pos; i++) {
	    n = n.getNext();
	}
	return n.getData();
    }

    public String set(int pos, String s) {
	Node n = head;
	for (int i = 0; i <= pos; i++) {
	    n = n.getNext();
	}
	String ans = n.getData();
	n.setData(s);
	return ans;
    }

    public String remove(int pos) {
	Node n1 = head.getNext();
	Node n2 = head;
	Node n3 = null;
	for(int i=0;i<=pos;i++){
	    n3 = n2;
	    n2 = n1;
	    n1 = n2.getNext();
	}
	String ans = n2.getData();
	n3.setNext(n1);
	if(n1 == null){
	    tail = n3;
	}
	length--;
	return ans;
    }

    public int find(String s) {
	Node curr = head.getNext();
	int ans = 0;
	while (curr != null && !curr.getData().equals(s)) {
	    curr = curr.getNext();
	    ans++;
	}
	if (curr != null) {
	    return ans;
	}
	return -1;
    }

    public void addToEnd(String s) {
        Node temp = new Node(s);
	tail.setNext(temp);
	tail = temp;
	length++;
    }

}