
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
    public static void main(String[] args){
	int[] L = new int[] {2,4,1,6,24,34,43,234,413,65,34,9,765};
	for(int i : mergeSort(L)){
	    System.out.println(i);
	}

    }
}