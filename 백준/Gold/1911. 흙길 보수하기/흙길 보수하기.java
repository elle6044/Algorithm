import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Point> pq=new PriorityQueue();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			pq.offer(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			
		}
		
		int cnt=0;
		int idx=0;
		
		while(!pq.isEmpty()) {
			Point p=pq.poll();
			idx=Math.max(idx, p.s);
			
			while(idx<p.e) {
				cnt++;
				idx+=L;
			}
		}
		
		bw.write(cnt+"");
		bw.close();

	}
	
	static class Point implements Comparable<Point>{
		int s,e;
		public Point(int s, int e) {
			this.s=s;
			this.e=e;
		}
		
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.e, o.e);
		}
		
	}

}
