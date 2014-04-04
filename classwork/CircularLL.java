public class CircularLL<E>{
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
	    current.setNext(current);
	    current.setPrev(current);
	}
	else{
	    n.next = current;
	    n.prev = current.prev;
	    current.prev.next = n;
	    current.prev = n;
	    current = n;
	}
    }
    public E getCurrent(){
	return current.getData();
    }
    public void forward(){
	current = current.getNext();
    }
    public void back(){
	current = current.getPrev();
    }
    public String toString(){
	if(current == null){
	    return "";
	}
	String ans = ""+current;
	Node<E> temp = current;
	while(temp.getNext() != current){
	    temp = temp.getNext();
	    ans += " "+temp;
	}
	return ans;
    }
    public void delete(){
	//delete the current node.
	if(current == null){
	    return;
	}
	current.prev.next = current.next;
	current.next.prev = current.prev;
	current = current.next;
    }
    public boolean find(E e){
	//if true, also moves current to the element in question
	if(current == null){
	    return false;
	}
	Node<E> oldCurrent = current;
	if(current.data.equals(e)){
	    return true;
	}
	forward();
	while(current != oldCurrent && !current.data.equals(e)){
	    forward();
	}
	return !(current == oldCurrent);
    }
    public static void main(String[] args){
	CircularLL<String> L = new CircularLL<String>();
	System.out.println(L);
	L.insert("hello");
	System.out.println(L);
       	L.insert("world");
       	System.out.println(L);
       	L.insert("three");
       	System.out.println(L);
      	System.out.println(L.getCurrent());
       	L.back();
       	System.out.println(L.getCurrent());
       	L.insert("inserted");
       	System.out.println(L);
	L.insert("DELETE");
	System.out.println(L);
	L.delete();
	System.out.println(L);
	System.out.println(L.getCurrent());
	System.out.println(L.find("four"));
	System.out.println(L.getCurrent());
    }
}