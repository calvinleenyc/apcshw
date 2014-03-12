import java.util.ArrayList;


public class NQueens {
	private class Pair{
		public int x;
		public int y;
		public Pair(int a, int b){
			x = a; y = b;
		}
		public String toString(){
			return "("+x + ", "+y+")";
		}
	}
	private int n;
	private ArrayList<Pair> queens = new ArrayList<Pair>();
	private boolean done = false;
	public NQueens(int en){
		n = en;
		//queens.add(new Pair(0,0));
	}
	public boolean placeQueens(){
//		for(int i=0;i<50;i++){
//			System.out.println("\n");
//		}
//		System.out.println(this);
//		try {
//			Thread.sleep(170);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//Pretty neat!
		
		if(done) return true;
		int col = 0;
		if(!queens.isEmpty()){
			col = queens.get(queens.size() - 1).x + 1;
			Pair last = queens.get(queens.size() - 1);
			for(int i=0;i<queens.size()-1;i++){
				if(underAttack(queens.get(i),last)){
					return false;
				}
			}
		}
		if(col >= n){
			done = true;
			return true;
		}
		
		
		for(int row = 0; row < n; row ++){
			if(!done){
				queens.add(new Pair(col,row));
				if(placeQueens()){
					done = true;
					return true;
				}
				else{
					queens.remove(queens.size() - 1);
				}
			}
		}
		return done;
	}
	private boolean underAttack(Pair a, Pair b) {
		return (a.x == b.x || a.y == b.y || a.x - b.x == a.y - b.y || a.x - b.x == b.y - a.y);
	}
	public String toString(){
		String answer = "";
//		for(int i=0;i<n;i++){
//			answer += "_";
//		}answer += "\n";
		for(Pair p : queens){
			answer += "|";
			for(int i=0;i<p.y;i++){
				answer += "_|";
			}
			answer += "Q|";
			for(int i=p.y+1;i<n;i++){
				answer += "_|";
			}
			answer += "\n";
		}
		return answer;
	}

}
