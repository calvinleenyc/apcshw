public class myLinkedList{
    private Node head;
    private int length;
    public myLinkedList(){
	head = null;
	length = 0;
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
	    ans += ", ";
	    ans += temp;
	}

	ans += "]";
	return ans;
    }
    public void addToFront(String s){
	Node temp = new Node(s);
	temp.setNext(head);
	head = temp;
	length ++;
    }
    public void add(int pos,String s){
	if(pos == 0){
	    addToFront(s);
	    return;
	}
	Node prev = head;
	for(int i=0;i<pos-1;i++){
	    prev = prev.getNext();
	}
	Node next = prev.getNext();
	Node add = new Node(s);
	prev.setNext(add);
	add.setNext(next);
	length ++;
    }
    public int length(){
	return length;
    }
    public String get(int pos){
	Node n = head;
	for(int i=0;i<pos;i++){
	    n = n.getNext();
	}
	return n.getData();
    }
    public String set(int pos,String s){
	Node n = head;
	for(int i=0;i<pos;i++){
	    n = n.getNext();
	}
	String ans = n.getData();
	n.setData(s);
	return ans;
    }
    public String remove(int pos){
	if(pos == 0){
	    String ans = head.getData();
	    head = head.getNext();
	    return ans;
	}
	Node prev = head;
	for(int i=0;i<pos-1;i++){
	    prev = prev.getNext();
	}
	Node curr = prev.getNext();
	Node next = curr.getNext();
	String ans = curr.getData();
	prev.setNext(next);
	length --;
	return ans;
    }
    public int find(String s){
	Node curr = head;
	int ans = 0;
	while(curr != null && !curr.getData().equals(s)){
	    curr = curr.getNext();
	    ans ++;
	}
	if(curr != null){
	    return ans;
	}
	return -1;
    }
    public void addToEnd(String s){
	add(length,s);
    }


}