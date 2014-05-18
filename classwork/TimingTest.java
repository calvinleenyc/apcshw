import java.util.*;
class TimingTest {
  public static void main(String[] args) {
    Map<String,String> M = new TreeMap<String,String>();
    long start = System.currentTimeMillis();
    for (int i = 0; i <10; i++) {
      M.put(Integer.toString(i), "foo");
    }
    long end = System.currentTimeMillis();
    // System.out.println(end - start);
    M = new HashMap<String,String>();
    start = System.currentTimeMillis();
    for (int i = 0; i <10; i++) {
      M.put(Integer.toString(i), "foo");
    }
    end = System.currentTimeMillis();
    // System.out.println(end - start);







    PriorityQueue<Integer> Q = new PriorityQueue<Integer>(5,Collections.reverseOrder());
    Q.add(5);
    Q.add(3);
    Q.add(10);
    Q.add(0);
    Q.add(23);
    System.out.println(Q.remove());
System.out.println(Q.remove());
System.out.println(Q.remove());
System.out.println(Q.remove());

  }
}