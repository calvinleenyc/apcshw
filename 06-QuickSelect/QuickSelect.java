
public class QuickSelect {
	public static int partition(int[] a, int pivot, int lo, int hi){
		//returns where the pivot ends up.
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
		int n = partition(a,p,lo,hi);
		if(n == k) return a[n];
		if(n < k){
			return quickSelectAUX(a,k,n+1,hi);
		}
		else{
			return quickSelectAUX(a,k,lo,n);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {4,1,8,6,2,7,5,0,3,9};
		//System.out.println(partition(a,0,0,a.length));
		System.out.println(quickSelect(a,4));
//		partition(a,0,0,a.length);
//		for(int i : a){
//			System.out.print(i+" ");
//		}
	}

}
