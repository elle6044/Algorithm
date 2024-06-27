import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,K;
	static long sum[];
	static PriorityQueue<Long> pq=new PriorityQueue(Comparator.reverseOrder());
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		sum=new long[N+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			sum[i]=sum[i-1]+Long.parseLong(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			pq.offer(sum[i]);
		}
		
		long answer=0;
		for(int i=0;i<K;i++) {
			answer+=pq.poll();
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
