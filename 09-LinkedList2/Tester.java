
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("!");
		myLinkedList2 a = new myLinkedList2();
		for(int i=0;i<=10;i++){
			a.addToFront(10 - i + "");
		}
		System.out.println(a.length());
		System.out.println(a);
		System.out.println(a.get(0));
		a.add(0, "A");
		System.out.println(a);
		a.addToEnd("Z");
		System.out.println(a);
		a.remove(0);
		System.out.println(a);
		System.out.println(a.find("0"));
	}

}
