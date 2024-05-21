import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Point> pq=new PriorityQueue();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int t=Integer.parseInt(st.nextToken());
			pq.offer(new Point(s,t));
		}
		
		int time=0;
		while(!pq.isEmpty()) {
			Point p=pq.poll();
			if(time<p.s) {
				time=p.s+p.t;
			}
			else {
				time+=p.t;
			}
		}
		
		bw.write(time+"");
		bw.close();

	}
	
	static class Point implements Comparable<Point>{
		int s,t;
		public Point(int s, int t) {
			this.s=s;
			this.t=t;
		}
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.s, o.s);
		}
	}

}
