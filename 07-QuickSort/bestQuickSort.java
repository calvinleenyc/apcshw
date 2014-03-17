
public class bestQuickSort {
	public static int[] partition(int[] a, int pivot, int lo, int hi){
		/*
		 * Three-way partitioning with only one loop through the array!!
		 * Invariant:
		 * Everything from lo to wall1 - 1 is less than the pivot value, val.
		 * Everything from wall1 to i-1 is equal to the pivot value.
		 * Everything from i to wall2 hasn't been processed yet.
		 * Everything from wall2 to hi-1 is greater than the pivot value.
		 * 
		 * 
		 * General information on variable names:
		 * int pivot is an INDEX, while int val is the value.
		 * lo is the first index we are considering, while
		 * hi is the first index we are NOT considering.
		 */
		int val = a[pivot];
		a[pivot] = a[lo];
		a[lo] = val;
		int wall1 = lo;
		int wall2 = hi;
		for(int i=lo;i<wall2;){
			int q = a[i];
			if(q < val){
				a[i] = a[wall1];
				a[wall1] = q;
				i++;
				wall1++;
			}
			else if(q > val){
				wall2--;
				a[i] = a[wall2];
				a[wall2] = q;
				
			}
			else{
				i++;
			}
		}
		
		return new int[] {wall1,wall2};
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {10,4,4,2,8,6,2,4,7,3,5,9,1,4,3,4};
		quickSort(a);
//		int[] n = partition(a,1,0,a.length);
		for(int i : a){
			System.out.print(i+" ");
		}System.out.println();
//		System.out.println(n[0]);
//		System.out.println(n[1]);
	}

}
