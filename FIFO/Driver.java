public class Driver {
    public static void main(String[] args) {
	myQueue q = new myQueue();
	q.enqueue("First");
	q.enqueue("Second");
	System.out.println(q.dequeue());
	q.enqueue("Third");
	System.out.println(q.dequeue());
	System.out.println(q.dequeue());
    }
}