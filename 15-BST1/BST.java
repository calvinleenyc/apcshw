public class BST {
	private class Node {
		private int data;
		private Node left,right;
		public Node(int d){
			setData(d);
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
	}
	private Node root;

	public BST() {
		root = null;
	}
	public void insert(int d){
		if(root == null){
			root = new Node(d);
			return;
		}
		Node now = root;
		Node prev = null;
		while(now != null){
			if(d < now.getData()){
				prev = now;
				now = now.getLeft();
			}
			else{
				prev = now;
				now = now.getRight();
			}
		}
		if(d < prev.getData()){
			prev.setLeft(new Node(d));
		}
		else{
			prev.setRight(new Node(d));
		}
	}
	public Node search(int d){
		Node now = root;
		while(now != null){
			if(d < now.getData()){
				now = now.getLeft();
			}
			else if(d > now.getData()){
				now = now.getRight();
			}
			else{
				return now;
			}
		}
		return null;
	}
	public Node search2(Node n, int d){
		if(n==null || n.getData() == d){
			return n;
		}
		if(d < n.getData()){
			return search2(n.getLeft(),d);
		}
		else{
			return search2(n.getRight(),d);
		}
	}
	public Node search2(int d){
		return search2(root,d);
	}

}