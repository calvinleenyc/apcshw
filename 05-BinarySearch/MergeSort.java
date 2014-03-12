import java.util.ArrayList;
import java.util.*;
class Person implements Comparable<Person>{
    private int age;
    private String name;
    public Person(int age1,String name1){age = age1;name = name1;}
    public int compareTo(Person other){
	return this.age - other.age;
    }
//    public int compareTo(Person other){
//    	return this.name.compareTo(other.name);
//    }//for part b, uncomment these 3 lines and comment out the three above.
    public String toString(){
	return age + "!" +name;
    }
}

public class MergeSort{
	//first implementation: naive, not optimized.
	public static  int[] merge1(int[] a, int[] b){
		int alength = a.length;
		int blength = b.length;
		int[] answer = new int[alength + blength];
		int progressa = 0;
		int progressb = 0;
		for(int i=0;i<a.length+blength;i++){
			//System.out.println(progressa + " " + progressb);
			if(progressa == alength){
				answer[i] = b[progressb];
				progressb++;
			}
			else if(progressb == blength){
				answer[i] = a[progressa];
				progressa++;
			}
			else{
				if(a[progressa] > b[progressb]){
					answer[i] = b[progressb];
					progressb++;
				}
				else{
					answer[i] = a[progressa];
					progressa++;
				}
			}

		}
		return answer;
	}
	public static int[] mergeSort(int[] L){
		if(L.length <= 1){
			return L;
		}
		int a = L.length / 2;
		int b = L.length - a;
		int[] A = new int[a];int[] B = new int[b];
		for(int i=0;i<a;i++){
			A[i] = L[i];
		}
		for(int i=0;i<b;i++){
			B[i] = L[a+i];
		}
		int[] newA = mergeSort(A);
		int[] newB = mergeSort(B);
		return merge1(newA,newB);
	}
	public static  ArrayList<Comparable> merge1(ArrayList<Comparable> a, ArrayList<Comparable> b){
		int alength = a.size();
		int blength = b.size();
		ArrayList<Comparable> answer = new ArrayList<Comparable>();
		int progressa = 0;
		int progressb = 0;
		for(int i=0;progressa < alength && progressb < blength;i++){
			if(a.get(progressa).compareTo(b.get(progressb)) > 0){
				answer.add(b.get(progressb));
				progressb++;
			}
			else{
				answer.add(a.get(progressa));
				progressa++;
			}
		}
		for(int i=progressa;i<alength;i++){
			answer.add(a.get(i));
		}
		for(int i=progressb;i<blength;i++){
			answer.add(b.get(i));
		}
		return answer;
	}
	public static ArrayList<Comparable> mergeSort(ArrayList<Comparable> L){
		if(L.size() <= 1){
			return L;
		}
		int a = L.size() / 2;
		int b = L.size() - a;
		ArrayList<Comparable> A = new ArrayList<Comparable>();
		ArrayList<Comparable> B = new ArrayList<Comparable>();
		for(int i=0;i<a;i++){
			A.add(L.get(i));
		}
		for(int i=0;i<b;i++){
			B.add(L.get(a+i));
		}
		A = mergeSort(A);
		B = mergeSort(B);
		return merge1(A,B);
	}
	public static void main(String[] args){
//		ArrayList<String> a = new ArrayList<String>();
//		a.add("A");a.add("E");a.add("I");a.add("O");a.add("U");
//		ArrayList<String> b = new ArrayList<String>();
//		b.add("B");b.add("C");b.add("L");b.add("W");b.add("Z");
//		System.out.println(merge1(a,b));
		ArrayList L = new ArrayList();
		for(int i=0;i<12;i++){
			L.add(new String(
					new char[] {(char) 
							((int) (97 + 26 * Math.random()))}
					));
		}
		System.out.println(L);
		L = mergeSort(L);
		System.out.println(L);
		L = new ArrayList();
		L.add(2);L.add(6);L.add(0);L.add(10);L.add(-1);L.add(23);L.add(24);
		System.out.println(L);
		L = mergeSort(L);
		System.out.println(L);
		L = new ArrayList();
		L.add(new Person(4,"A"));
		L.add(new Person(6,"E"));
		L.add(new Person(2,"B"));
		L.add(new Person(109,"Q"));
		L.add(new Person(3,"AE"));
		System.out.println(L);
		L = mergeSort(L);
		System.out.println(L);


//		int[] L = new int[] {2,4,1,6,24,34,43,234,413,65,34,9,765};
//		for(int i : mergeSort(L)){
//			System.out.println(i);
//		}

	}
}