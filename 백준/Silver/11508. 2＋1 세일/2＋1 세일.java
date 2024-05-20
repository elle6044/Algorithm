import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq=new PriorityQueue(Comparator.reverseOrder());
		for(int i=0;i<N;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int answer=0;
		while(pq.size()>=3) {
			answer+=pq.poll();
			answer+=pq.poll();
			pq.poll();
		}
		
		while(!pq.isEmpty()) {
			answer+=pq.poll();
		}
		bw.write(answer+"");
		bw.close();

	}

}
