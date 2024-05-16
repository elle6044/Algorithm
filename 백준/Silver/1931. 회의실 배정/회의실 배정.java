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
			pq.offer(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		int now=0;
		int cnt=0;
		while(!pq.isEmpty()) {
			Point p=pq.poll();
			if(p.s>=now) {
				now=p.e;
				cnt++;
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
			return this.e==o.e?Integer.compare(this.s, o.s):Integer.compare(this.e, o.e);
		}
	}

}
