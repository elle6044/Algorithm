import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer>pq=new PriorityQueue();
		
		for(int i=0;i<N;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		int answer=0;
		while(pq.size()>=2) {
			int a=pq.poll();
			int b=pq.poll();
			answer+=a+b;
			pq.offer(a+b);
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
