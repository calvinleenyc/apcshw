
public class OldQuickSort {
	/*
	 * General information on variables:
	 * int pivot is an INDEX, while int val is the value.
	 * lo is the first index we are considering, while
	 * hi is the first index we are NOT considering.
	 * 
	 */
	public static int wastefulPartition(int[] a, int pivot, int lo, int hi){
		/*
		 * Uses a separate array and fills it
		 * from the bottom up and from the top down
		 * then fills in the rest with the pivot value.
		 * (I liked this approach much better than
		 * the whole arraylist thing).
		 * Still uses a bunch of extra memory.
		 * Returns where the pivot ends up.
		 */
		int[] b = new int[a.length];
		int l = lo;
		int h = hi;
		for(int i = lo; i < hi; i++){
			if(a[i] < a[pivot]){
				b[l] = a[i];
				l++;
			}
			else if(a[i] > a[pivot]){
				h--;
				b[h] = a[i];
			}
		}
		for(int i = l; i < h; i++){
			b[i] = a[pivot];
		}
		for(int i=lo;i<hi;i++){
			a[i] = b[i];
		}
		return l;
	}
	public static int inPlacePartition(int[] a, int pivot, int lo, int hi){
		/*
		 *
		 * An in-place partitioning algorithm.
		 * It doesn't handle duplicate values well.
		 * Divides the array into 4 sections:
		 * the first section, from lo to wall-1, is < pivot.
		 * the second, from wall to i-1, is >= pivot.
		 * the third, from i to hi-2, is yet to be considered.
		 * the fourth, at hi-1, holds in reserve the pivot.
		 */
		int val = a[pivot];
		a[pivot] = a[hi-1];
		a[hi-1] = val;
		//throws the pivot into the last spot for now; will be fixed at the end.		
		int wall = lo;//wall is the first index of the section >= pivot
		for(int i = lo; i < hi-1; i++){
			int q = a[i];//the value in question
			if(q < val){
				a[i] = a[wall];
				a[wall] = q;
				wall ++;
				//idea: add the value to the section <pivot
				//and expand that section.
			}
			//otherwise this thing is fine where it is.
		}
		a[hi-1] = a[wall];
		a[wall] = val;
		//putting the pivot where it belongs.
		return wall;
	}
	public static int quickSelect(int[] a, int k){
		return quickSelectAUX(a,k,0,a.length);
	}
	public static int quickSelectAUX(int[] a, int k, int lo, int hi){
//		for(int i : a){
//			System.out.print(i + " ");
//		}System.out.println("");
		if(lo >= hi){
			return a[lo];
		}
		int p = lo + (int)(Math.random() * (hi - lo));
		int n = wastefulPartition(a,p,lo,hi);
		if(n == k) return a[n];
		if(n < k){
			return quickSelectAUX(a,k,n+1,hi);
		}
		else{
			return quickSelectAUX(a,k,lo,n);
		}
	}
	public static void quickSortAUX(int[] a, int lo, int hi){
		if(lo >= hi){
			return;
		}
//		for(int i : a){//for debugging, uncomment these lines.
//			System.out.print(i+" ");
//		}System.out.println();
		int p = lo + (int)(Math.random() * (hi - lo));
		int n = inPlacePartition(a,p,lo,hi);
		quickSortAUX(a,lo,n);
		quickSortAUX(a,n+1,hi);
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
		// TODO Auto-generated method stub
		int[] a = new int[] {4,1,8,6,2,7,5,0,3,9};
		//System.out.println(partition(a,0,0,a.length));
		//System.out.println(quickSelect(a,4));
//		partition(a,0,0,a.length);
		quickSort(a);
		for(int i : a){
			System.out.print(i+" ");
		}
	}

}
