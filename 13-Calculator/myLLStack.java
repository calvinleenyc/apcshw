public class myLLStack<E>{
	private class Node<Q>{
		private Q data;
		private Node<Q> next;
		public Node(Q d){
			data = d;
			next = null;
		}
		public void setData(Q d){
			data = d;
		}
		public void setNext(Node<Q> n){
			next = n;
		}
		public Node<Q> getNext(){
			return next;
		}
		public Q getData(){
			return data;
		}
		public String toString(){
			return data.toString();
		}
	}
	private Node<E> top;
	private int length;
	//constructor
	public myLLStack(){
		top = null;
		length = 0;
	}
	public void push(E s){
		Node<E> n = new Node<E>(s);
		n.setNext(top);
		top = n;
		length++;
	}
	public E pop(){
		E ans = top.getData();
		top = top.getNext();
		length --;
		return ans;
	}
	public E peek(){
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
		for(Node<E> temp = top; temp != null; temp = temp.getNext()){
			ans += temp.getData() + ", ";
		}
		return ans;
	}
}