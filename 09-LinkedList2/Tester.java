
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
		myLinkedList2 b = new myLinkedList2();
		for(int i=0;i<12;i++){
		    b.addToEnd(""+i);
		}
		System.out.println(b);
		b.remove(11);
		System.out.println(b);
		b.addToEnd(""+19);
		System.out.println(b);
		System.out.println(b.length());
		b.remove(6);
		System.out.println(b);
		System.out.println(b.length());
		b.add(11,""+89);
		System.out.println(b);

	}

}
