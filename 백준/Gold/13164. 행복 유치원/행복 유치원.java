import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq=new PriorityQueue(Comparator.reverseOrder());
		st=new StringTokenizer(br.readLine());
		
		int pre=Integer.parseInt(st.nextToken());
		for(int i=1;i<N;i++) {
			int next=Integer.parseInt(st.nextToken());
			pq.offer(next-pre);
			pre=next;
		}
		
		for(int i=0;i<K-1;i++) {
			pq.poll();
		}
		
		int answer=0;
		while(!pq.isEmpty()) {
			answer+=pq.poll();
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
