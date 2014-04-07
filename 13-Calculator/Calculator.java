import java.util.Scanner;
import java.util.StringTokenizer;


public class Calculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		myLLStack<Integer> stack = new myLLStack<Integer>();
		System.out.println("You can enter your query on a single line " +
				"(if you wish to skip intermediate results), or multiple lines.  Separate terms with" +
				" spaces if using a single line.");
		System.out.println("To clear the stack, use the word 'clear'.  " +
				"When completed, end your query with the word 'exit'.");
		while(true){
			while(sc.hasNext()){
				String line = sc.nextLine();
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreTokens()){
					String s = st.nextToken();
					if(s.equals("exit")){
						return;
					}
					if(s.equals("clear")){
						stack = new myLLStack<Integer>();
					}
					else if(s.equals("+")){
						int b = stack.pop();
						int a = stack.pop();
						stack.push(a+b);
					}
					else if(s.equals("-")){
						int b = stack.pop();
						int a = stack.pop();
						stack.push(a-b);
					}
					else if(s.equals("*")){
						int b = stack.pop();
						int a = stack.pop();
						stack.push(a*b);
					}
					else if(s.equals("/")){
						int b = stack.pop();
						int a = stack.pop();
						stack.push(a/b);
						//let's not deal with when to display a float and when to display an int. 
					}
					else{
						stack.push(Integer.parseInt(s));
					}
				}
				if(!stack.isEmpty())System.out.println(stack.peek());
			}
		}
		
	}

}
