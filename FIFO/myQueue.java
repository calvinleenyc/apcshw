public class myQueue {
    private Node head;
    private Node tail;
    private int size;
    public myQueue(){
	head = null;
	tail = null;
	size = 0;
    }
    public void enqueue(String s){
	length++;
	Node n = new Node(s);
	if(head == null){
	    head = n;
	    tail = n;
	}
	else {
	    tail.setNext(n);
	    tail = n;
	}
    }
    public String dequeue(){
	length--;
	String s = head.getData();
	head = head.getNext();
	if(head == null){
	    tail = null;
	}
	return s;
    }
    public boolean isEmpty(){
	return head == null;
    }
    public String front(){
	return head.getData();
    }
    public int size(){
	return size;
    }
}