public class DoubleLL<E>{
    private class Node<E>{
	E data;
	Node<E> next,prev;
	public Node(E d){
	    this.data = d;
	}
	public String toString(){
	    return ""+data;
	}
	public void setData(E d){
	    data = d;
	}
	public E getData(){return data;}
	public void setNext(Node<E> n){
	    next = n;
	}
	public void setPrev(Node<E> n){
	    prev = n;
	}
	public Node<E> getNext(){
	    return next;
	}
	public Node<E> getPrev(){return prev;}
    }
    private Node<E> current;
    public void insert(E d){
	Node<E> n = new Node<E>(d);
	if(current == null){
	    current = n;
	}
	else{
	    n.next = current;
	    n.prev = current.prev;
	    if(current.prev != null){
		current.prev.next = n;
	    }
	    current.prev = n;
	    current = n;
	}
    }
    public E getCurrent(){
	return current.getData();
    }
    public void forward(){
	if(current.getNext()!=null){
	    current = current.getNext();
	}
    }
    public void back(){
	if(current.getPrev() != null){
	    current = current.getPrev();
	}
    }
    public String toString(){
	if(current == null){
	    return "";
	}
	String ans = ""+current;
	Node<E> temp = current;
	while(temp.getNext() != null){
	    temp = temp.getNext();
	    ans += " "+temp;
	}
	temp = current;
	while(temp.getPrev() != null){
	    temp = temp.getPrev();
	    ans = temp+" "+ans;
	}
	return ans;
    }
    public static void main(String[] args){
	DoubleLL<String> L = new DoubleLL<String>();
	System.out.println(L);
	L.insert("hello");
	System.out.println(L);
	L.insert("world");
	System.out.println(L);
	L.insert("three");
	System.out.println(L);
	System.out.println(L.getCurrent());
	L.forward();
	System.out.println(L.getCurrent());
	L.insert("inserted");
	System.out.println(L);
    }
}