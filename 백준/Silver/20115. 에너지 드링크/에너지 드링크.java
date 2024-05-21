import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		PriorityQueue<Double>pq=new PriorityQueue(Comparator.reverseOrder());
		for(int i=0;i<N;i++) {
			pq.offer(Double.parseDouble(st.nextToken()));
		}
		
		double answer=pq.poll();
		while(!pq.isEmpty()) {
			double drink=pq.poll();
			answer+=drink/2;
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
