
public class myArrayStack {
	private String[] a;
	private int top;//top is the location of the highet one
	private int arrayLength;
	public myArrayStack(){
		top = -1;
		arrayLength = 10;
		a = new String[10];
	}
	public void push(String s){
		top ++;
		if(top == arrayLength){
			String[] b = new String[arrayLength * 2];
			for(int i=0;i<arrayLength;i++){
				b[i] = a[i];
			}
			b[top] = s;
			a = b;
			arrayLength *= 2;
		}
		else{
			a[top] = s;
		}
	}
	public String pop(){
		top--;
		return a[top + 1];
	}
	public String peek(){
		return a[top];
	}
}
