import java.util.ArrayList;


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
	public static  ArrayList<String> merge1(ArrayList<String> a, ArrayList<String> b){
		int alength = a.size();
		int blength = b.size();
		ArrayList<String> answer = new ArrayList<String>();
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
	public static ArrayList<String> mergeSort(ArrayList<String> L){
		if(L.size() <= 1){
			return L;
		}
		int a = L.size() / 2;
		int b = L.size() - a;
		ArrayList<String> A = new ArrayList<String>();
		ArrayList<String> B = new ArrayList<String>();
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
	public static int find(String x,ArrayList<String> a){
		int lo = 0;
		int hi = a.size() - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			String val = a.get(mid);
			if(val.equals(x)) return mid;
			else if(val.compareTo(x) < 0) lo = mid+1;
			else if(val.compareTo(x) > 0) hi = mid-1;
		}
		return -1;
	}
	public static void main(String[] args){
//		ArrayList<String> a = new ArrayList<String>();
//		a.add("A");a.add("E");a.add("I");a.add("O");a.add("U");
//		ArrayList<String> b = new ArrayList<String>();
//		b.add("B");b.add("C");b.add("L");b.add("W");b.add("Z");
//		System.out.println(merge1(a,b));
		ArrayList<String> L = new ArrayList<String>();
		for(int i=0;i<12;i++){
			L.add(new String(
					new char[] {(char) 
							((int) (97 + 26 * Math.random()))}
					));
		}
		System.out.println(L);
		L = mergeSort(L);
		System.out.println(L);
		System.out.println(find("c",L));
		System.out.println(find("l",L));
		System.out.println(find("z",L));
//		int[] L = new int[] {2,4,1,6,24,34,43,234,413,65,34,9,765};
//		for(int i : mergeSort(L)){
//			System.out.println(i);
//		}

	}
}