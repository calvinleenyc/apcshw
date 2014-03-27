public class DoubleLL<E>{
	private class Node<Q>{
		Q data;
		Node<Q> next,prev;
		public Node(Q d){
			this.data = d;
		}
		public String toString(){
			return ""+data;
		}
		public void setData(Q d){
			data = d;
		}
		public Q getData(){return data;}
		public void setNext(Node<Q> n){
			next = n;
		}
		public void setPrev(Node<Q> n){
			prev = n;
		}
		public Node<Q> getNext(){
			return next;
		}
		public Node<Q> getPrev(){return prev;}
	}
	private Node<E> current;
	public void insert(E d){
		Node<E> n = new Node<E>(d);
		if(current == null){
			current = n;
		}
		else{
			n.setNext(current);
			n.setPrev(current.prev);
			if(current.prev != null){
				current.prev.setNext(n);
			}
			current.setPrev(n);
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