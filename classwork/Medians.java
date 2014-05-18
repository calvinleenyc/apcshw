import java.util.*;
public class Medians {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(11);
    int maxSize = 0;
    int minSize = 0;
    public void add(int n){
	if(maxHeap.isEmpty()){
	    minHeap.add(n);
	    minSize++;
	}
	else if(n < maxHeap.peek()){
	    maxHeap.add(n);
	    maxSize++;
	}
	else{
	    minHeap.add(n);
	    minSize++;
	}
        if(maxSize -  minSize == 2){
	    minHeap.add(maxHeap.poll());
	    minSize++;
	    maxSize--;
	}
	else if(maxSize -  minSize == -2){
	    maxHeap.add(minHeap.poll());
	    minSize--;
	    maxSize++;
	}
    }
    public double getMedian(){
	if(maxSize == minSize){
	    return (maxHeap.peek() + minHeap.peek())/2.0;
	}
	else if(maxSize > minSize){
	    return maxHeap.peek();
	}
	else return minHeap.peek();
    }
    public double removeMedian(){
	if(maxSize == minSize){
	    int a = maxHeap.poll();
	    int b = minHeap.poll();
	    minSize--;maxSize--;
	    return (a+b)/2.0;
	}
	else if(maxSize > minSize){
	    maxSize--;
	    return maxHeap.poll();
	}
	else{
	    minSize--;
	    return minHeap.poll();
	}
    }
    public static void main(String[] args){
	long start = System.currentTimeMillis();
	Medians M = new Medians();
	int N = 10000000;
	int U = 100;
	for(int i=0;i<N;i++){
	    M.add((int)( U * Math.random()));
	}
	System.out.println(M.getMedian());
	//	for(int i=0;i<N/2;i++){
	//   M.removeMedian();
	//}
	long end = System.currentTimeMillis();
	System.out.println(end - start);

    }

}