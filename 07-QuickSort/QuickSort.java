
public class QuickSort {
	/*
	 * General information on variables:
	 * int pivot is an INDEX, while int val is the value.
	 * lo is the first index we are considering, while
	 * hi is the first index we are NOT considering.
	 * 
	 */
	public static int[] partition(int[] a, int pivot, int lo, int hi){
		/*
		 *
		 * A good partitioning algorithm that handles duplicates
		 * and sorts in place.  After doing the standard first loop,
		 * it goes through everything >= pivot and moves it into the middle.
		 */
		int val = a[pivot];
		a[pivot] = a[hi-1];
		a[hi-1] = val;	
		int wall = lo;
		for(int i = lo; i < hi-1; i++){
			int q = a[i];
			if(q < val){
				a[i] = a[wall];
				a[wall] = q;
				wall ++;
			}
		}
		int wall2 = wall;
		for(int i = wall; i < hi; i++){
			if(a[i] == val){
				a[i] = a[wall2];
				a[wall2] = val;
				wall2++;
			}
		}
		//putting the pivots where they belong.
		
		return new int[] {wall,wall2};
	}
	public static int quickSelect(int[] a, int k){
		return quickSelectAUX(a,k,0,a.length);
	}
	public static int quickSelectAUX(int[] a, int k, int lo, int hi){
		if(lo >= hi){
			return a[lo];
		}
		int p = lo + (int)(Math.random() * (hi - lo));
		int[] n = partition(a,p,lo,hi);
		if(n[0] <= k && k < n[1]) return a[n[0]];
		if(n[1] <= k){
			return quickSelectAUX(a,k,n[1],hi);
		}
		else{
			return quickSelectAUX(a,k,lo,n[0]);
		}
	}
	public static void quickSortAUX(int[] a, int lo, int hi){
		if(lo >= hi){
			return;
		}
//		for(int i : a){//for debugging, uncomment these lines.
//			System.out.print(i+" ");
//		}System.out.println();
		
		
		//CHOOSE A PIVOT:
//		int p = lo + (int)(Math.random() * (hi - lo));
		int e1 = a[lo];
		int e2 = a[hi-1];
		int e3 = a[(lo + hi) / 2];
		int p = 0;
		if((e1 <= e2 && e2 <= e3) || (e3 <= e2 && e2 <= e1)){
			p = hi - 1;
		}
		else if((e3 <= e1 && e1 <= e2) || (e2 <= e1 && e1 <= e3)){
			p = lo;
		}
		else{
			p = (lo + hi) / 2;
		}
		
		int[] n = partition(a,p,lo,hi);
		quickSortAUX(a,lo,n[0]);
		quickSortAUX(a,n[1],hi);
		return;
	}
	public static void quickSort(int[] a){
		quickSortAUX(a,0,a.length);
		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int N = 40000000;
//		int[] a = new int[N];
//		for(int i = 0; i < N; i++){
//			a[i] = (int)( 2*N * Math.random());
//		}
		//int[] a = new int[] {4,1,8,6,2,4,7,5,4,0,3,9,4};
		//int[] n = partition(a,0,0,a.length);
		//System.out.println(partition(a,0,0,a.length));
		//System.out.println(quickSelect(a,7));
//		partition(a,0,0,a.length);
//		long startTime = System.currentTimeMillis();
//		quickSort(a);
//		long endTime = System.currentTimeMillis();
//	    long totalTime = endTime - startTime;
//	    System.out.println(totalTime);
//		for(int i : a){
//			System.out.print(i+" ");
//		}
		//System.out.println();
		//System.out.println(n[0] + " " + n[1]);
	}

}
