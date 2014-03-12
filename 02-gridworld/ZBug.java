
public class SpiralBug extends Bug{
	private int steps;
	private int sideLength;
	public SpiralBug(int length){
		steps = 0;
		sideLength = length;
	}
	private int state = 0;
	public void act(){
		if(canMove()){
			if(state == 0){
				if(steps < sideLength){
					move();
					steps++;
				}
				else{
					turn();
					turn();
					turn();
					state = 1;
				}
			}
			else if(state == 1){
				if(steps < sideLength){
					move();
					steps ++;
				}
				else{
					turn();
					turn();
					turn();
					turn();
					turn();
					turn();
					turn();
				}
			}
			if(state == 2){
				if(steps < sideLength){
					move();
					steps++;
				}
			}
		}
	}

}
