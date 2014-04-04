public class myStack{
    private Node top;
    private int length;
    //constructor
    public myStack(){
	top = null;
	length = 0;
    }
    public void push(String s){
	Node n = new Node(s);
	n.setNext(top);
	top = n;
	length++;
    }
    public String pop(){
	String ans = top.getData();
	top = top.getNext();
	return ans;
	length --;
    }
    public String peek(){
	return top.getData();
    }
    public int size(){
	return length;
    }
    public boolean isEmpty(){
	return top == null;
    }
    public String toString(){
	String ans = "";
	for(Node temp = top; temp != null; temp = temp.getNext()){
	    ans += temp.getData() + ", ";
	}
	return ans;
    }
}