public class Driver{
    public static void main(String[] args){
	myLinkedList a = new myLinkedList();
	a.addToFront("5");
	a.addToFront("4");
	a.addToFront("3");
	a.addToFront("2");
	a.addToFront("1");
	a.addToFront("0");
	System.out.println(a);
	a.add(0,"A");
	System.out.println(a);
	System.out.println(a.length());
	System.out.println(a.get(3));
	System.out.println(a.set(4,"FOUR"));
	System.out.println(a);
	System.out.println(a.remove(2));
	System.out.println(a);
	a.add(1,"ONE");
	System.out.println(a);
	System.out.println(a.length());
	a.addToEnd("!");
	System.out.println(a);
	System.out.println(a.find("B"));
    }
}