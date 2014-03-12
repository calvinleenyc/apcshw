
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		KnightsTour e = new KnightsTour(8);
//		e.tour();
		NQueens q = new NQueens(20);
		System.out.println(q.placeQueens());
		System.out.println(q);
	}

}
