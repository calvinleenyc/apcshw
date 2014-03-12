import java.io.IOException;


public class KnightsTour {
	private int n;
	private int count = 1;
	private int[][] board;
	boolean done = false;
	public KnightsTour(int e){
		n = e;
		board = new int[e][e];
	}
	public int[][] eligible(int m, int n){
		return new int[][] {new int[] {m-1,n+2}, new int[] {m-2,n+1},
				new int[] {m-2,n-1}, new int[] {m-1,n-2},
				new int[] {m+1,n-2}, new int[] {m+2, n-1},
				new int[] {m+2, n+1}, new int[] {m+1,n+2}};
	}
	public boolean tour(int x, int y){
//		for(int i=0;i<50;i++){
//			System.out.println("\n");
//		}
//		System.out.println(this);
//		try {
//			Thread.sleep(150);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//Pretty neat!
		if(x < 0 || x >= n || y < 0 || y >= n) return false;
		if(board[x][y] != 0) return false;
		board[x][y] = count;
		for(int[] square : eligible(x,y)){
			if(!done){//all previous attempts have failed
				count ++;
				if(tour(square[0],square[1])){
					done = true;//this is the last one we do
					return true;
				}
				count --;
			}
		}
		done = true;
		for(int[] thi : board){
			for(int th : thi){
				if(th == 0) done = false;
			}
		}
		if(!done){
			board[x][y] = 0;
			return false;
		}
		return done;
	}
	public void tour(){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(tour(i,j)){
					System.out.println(this);
					return;
				}
			}
		}
		System.out.println("Tour cannot be completed.");
	}
	public String toString(){//a nice, neat print-out.
		String answer = "";
		for(int i=0;i<n;i++){
			if(i!=0)answer += "\n";
			for(int j=0;j<n;j++){
				if(j!=0)answer += " ";
				answer += board[i][j];
				if(board[i][j] < 10) answer += " ";
			}
		}
		return answer;
	}
}
