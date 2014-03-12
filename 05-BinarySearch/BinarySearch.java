import java.util.*;
public class BinarySearch {
	public static int iterBSearch(int x, int[] a){
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(a[mid] == x) return mid;
			else if(a[mid] < x) lo = mid+1;
			else if(a[mid] > x) hi = mid-1;
		}
		return -1;
	}
	public static int findInsertionSpot(int x, int[] a, int start, int end){
		int lo = start;
		int hi = end - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(a[mid] == x) return mid;
			else if(a[mid] < x) lo = mid+1;
			else if(a[mid] > x) hi = mid-1;
		}
		return lo;
	}
	public static int findInsertionSpot(int x, int[] a){
		return findInsertionSpot(x,a,0,a.length);
	}
 public static int recurBSearch(int x, int[] a){
	if(a.length == 0)return -1;
	int mid = a.length / 2;
	int val = a[mid] - x;
	//System.out.println(val);
	if(val == 0) return mid;
	if(val< 0){
	    int[] b = new int[a.length - mid - 1];
	    for(int i = mid+1; i < a.length; i ++){
		b[i - mid - 1] = a[i];
	    }
	    return mid + 1+recurBSearch(x,b);
	}
	else{
	    int[] b = new int[mid];
	    for(int i = 0; i < mid; i ++){
		b[i] = a[i];
	    }
	    return recurBSearch(x,b);
	}
    }
    public static int recurBSearch(Integer x, ArrayList<Integer> a){
	if(a.size() == 0)return -1;
	int mid = a.size() / 2;
	int val = a.get(mid).compareTo(x);
	//System.out.println(val);
	if(val == 0) return mid;
	if(val< 0){
	    ArrayList<Integer> b = new ArrayList<Integer>();
	    for(int i = mid+1; i < a.size(); i ++){
		b.add(a.get(i));
	    }
	    return mid + 1+recurBSearch(x,b);
	}
	else{
	    ArrayList<Integer> b = new ArrayList<Integer>();
	    for(int i = 0; i < mid; i ++){
		b.add(a.get(i));
	    }
	    return recurBSearch(x,b);
	}
    }
	public static int iterBSearch(Comparable x,ArrayList<Comparable> a){
		int lo = 0;
		int hi = a.size() - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			Comparable val = a.get(mid);
			if(val.equals(x)) return mid;
			else if(val.compareTo(x) < 0) lo = mid+1;
			else if(val.compareTo(x) > 0) hi = mid-1;
		}
		return -1;
	}
	public static void main(String[] args){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(-20);
		a.add(-10);
		a.add(0);
		a.add(7);
		a.add(8);
		a.add(100);
		a.add(200);
		//	System.out.println(recurBSearch(new Integer(200),a));
		int[] b = new int[] {-20,-10,0,7,8,100,200,2014};
		//System.out.println(recurBSearch(-30,b));
	}
}
