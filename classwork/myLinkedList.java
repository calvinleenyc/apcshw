public class myLinkedList{
    private Node head;
    private myLinkedList(){
	head = null;
    }
    public String toString(){
	String ans = "[";
	Node temp = head;
	if(temp == null){
	    return ans + "]";
	}
	ans += head;
	while(temp.getNext() !=null){
	    temp = temp.getNext();
	    ans += ",";
	    ans += temp;
	}

	ans += "]";
	return ans;
    }
    public void addToFront(String s){
	Node temp = new Node(s);
	temp.setNext(head);
	head = temp;
    }
    

}