import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int L=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq=new PriorityQueue();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<L;i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		int n=Integer.parseInt(br.readLine());
		
		int min=0;
		while(pq.peek()<n) {
			min=pq.poll();
		}
		int max=pq.poll();
		
		min++;
		max--;
		
		int answer=0;
		
		answer+=(n-min)*(max-n+1);
		
		for(int i=n+1;i<=max;i++) {
			answer++;
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
