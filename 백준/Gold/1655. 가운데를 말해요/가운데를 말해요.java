import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq1=new PriorityQueue(Comparator.reverseOrder());
		PriorityQueue<Integer> pq2=new PriorityQueue();
		
		pq1.add(Integer.parseInt(br.readLine()));
		bw.write(pq1.peek()+"\n");
		
		if(N>=2) {
			int a=pq1.poll();
			int b=Integer.parseInt(br.readLine());
			pq1.add(Math.min(a, b));
			pq2.add(Math.max(a, b));
			bw.write(pq1.peek()+"\n");
		}
		
		for(int n=3;n<=N;n++) {
			int now=Integer.parseInt(br.readLine());
			int a=pq1.peek();
			int b=pq2.peek();
			if(now<=b) {
				pq1.add(now);
				if(pq1.size()-pq2.size()>=2) {
					pq2.add(pq1.poll());
				}
			}
			else {
				pq2.add(now);
				if(pq2.size()-pq1.size()>=1) {
					pq1.add(pq2.poll());
				}
			}
			bw.write(pq1.peek()+"\n");
		}
		
		bw.close();

	}

}
