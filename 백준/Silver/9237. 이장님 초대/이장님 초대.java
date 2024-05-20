import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq=new PriorityQueue(Comparator.reverseOrder());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		int answer=1;
		int plus=1;
		while(!pq.isEmpty()) {
			int day=pq.poll();
			answer=Math.max(answer, day+plus++);
		}
		answer++;
		
		bw.write(answer+"");
		bw.close();
	}

}
