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
			String name=st.nextToken();
			pq.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),name));
		}
		
		while(!pq.isEmpty()) {
			Point p=pq.poll();
			bw.write(p.name+"\n");
		}
		bw.close();
	}
	
	static class Point implements Comparable<Point>{
		int a,b,c;
		String name;
		public Point(int a, int b, int c, String name) {
			this.a=a;
			this.b=b;
			this.c=c;
			this.name=name;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.a==o.a?this.b==o.b?this.c==o.c?this.name.compareTo(o.name):Integer.compare(o.c, this.c):Integer.compare(this.b, o.b):Integer.compare(o.a, this.a);
		}
	}

}
