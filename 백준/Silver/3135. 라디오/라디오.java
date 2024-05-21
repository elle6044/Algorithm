import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq=new PriorityQueue();
		for(int i=0;i<N;i++) {
			pq.offer(Math.abs(B-Integer.parseInt(br.readLine()))+1);
		}
		pq.offer(Math.abs(B-A));
		
		bw.write(pq.poll()+"");
		bw.close();
	}

}
