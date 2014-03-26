import java.util.*;

public class LinkedList3<E> implements Iterable<E> {
	/*
	 * A self-contained implementation written by me at home.
	 * My partner, Leon, did the typing during class,
	 * but the result didn't work well, and I am unfamiliar with
	 * the code he began with.  (Of course, I am familiar with
	 * the modifications he made to it, and I'm not quite sure
	 * why his version didn't operate.)
	 * 
	 * Thus, this project is completely my own work.
	 */
	private class Node<Q>{
		private Q data;
		private Node<Q> next;
		public Node(Q d){
			data = d;
			next = null;
		}
		public void setNext(Node<Q> n){
			next = n;
		}
		public void setData(Q q){
			data = q;
		}
		public Node<Q> getNext(){
			return next;
		}
		public Q getData(){
			return data;
		}
		public String toString(){
			if(data == null){
				return null;
			}
			return data.toString();
		}
	}
	private class LL3Iterator<T> implements Iterator<T>{
		private Node<T> current;
		public LL3Iterator(Node<T> h){
			current = h;
		}
		public boolean hasNext() {
			return current!= null;
		}

		public T next() {
			T ans = current.getData();
			current = current.getNext();
			return ans;
		}
		public void remove() {
			//do nothing.
		}

		
	}
	private Node<E> head;
	private Node<E> tail;
	private int length;
	public LinkedList3(){
		head  = new Node<E>(null);
		tail = head;
		length = 0;
	}
	public Iterator<E> iterator() {
		return new LL3Iterator<E>(head.getNext());
	}
	public String toString(){
		//uses the iterator, which I wrote first.
		String ans = "";
		for(E e : this){
			ans += ", "+e;
		}
		if(!ans.isEmpty()){
			ans = ans.substring(2);
		}
		ans = "[" + ans;
		ans += "]";
		return ans;
	}
	public void addFront(E q){
		Node<E> n = new Node<E>(q);
		if(head == tail){
			tail = n;
		}
		n.setNext(head.getNext());
		head.setNext(n);
		length ++;
	}
	public void add(E q){
		Node<E> n = new Node<E>(q);
		tail.setNext(n);
		tail = n;
		length++;
	}
	public void add(int pos, E s) {
		if(pos == length){
		    add(s);
		    return;
		}
		Node<E> n1 = head;
		Node<E> n2 = null;
		for(int i=0;i<=pos;i++){
		    n2 = n1;
		    n1 = n2.getNext();
		}
		Node<E> temp = new Node<E>(s);
		temp.setNext(n1);
		n2.setNext(temp);
		length++;
	}
	public int size(){
		return length;
	}
	public E get(int pos) {
		Node<E> n = head;
		for (int i = 0; i <= pos; i++) {
		    n = n.getNext();
		}
		return n.getData();
	}
	public E set(int pos, E s) {
		Node<E> n = head;
		for (int i = 0; i <= pos; i++) {
		    n = n.getNext();
		}
		E ans = n.getData();
		n.setData(s);
		return ans;
	}
	public E remove(int pos) {
		Node<E> n1 = head.getNext();
		Node<E> n2 = head;
		Node<E> n3 = null;
		for(int i=0;i<=pos;i++){
		    n3 = n2;
		    n2 = n1;
		    n1 = n2.getNext();
		}
		E ans = n2.getData();
		n3.setNext(n1);
		if(n1 == null){
		    tail = n3;
		}
		length--;
		return ans;
	}
	public int find(E s) {
		Node<E> curr = head.getNext();
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
	public static void main(String[] args){//for debugging purposes only.
		LinkedList3<Integer> a = new LinkedList3<Integer>();
		System.out.println(a);
		a.addFront(8);
		System.out.println(a.head.getNext());
		System.out.println(a);
		a.addFront(9);
		System.out.println(a);
		a.add(1);
		System.out.println(a);
		a.add(3,3);
		System.out.println(a);
		a.add(20);
		System.out.println(a);
		System.out.println(a.get(2));
		a.set(2, 900);
		System.out.println(a);
		a.remove(2);
		System.out.println(a);
		System.out.println(a.size());
		System.out.println(a.find(3));
		a.add(2,34);
		a.addFront(10);
		System.out.println(a);
	}

}
