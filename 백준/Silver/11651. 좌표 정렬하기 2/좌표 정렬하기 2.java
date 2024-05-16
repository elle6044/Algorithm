import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Point>pq=new PriorityQueue();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			pq.offer(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		while(!pq.isEmpty()) {
			Point p=pq.poll();
			bw.write(p.x+" "+p.y+"\n");
		}
		bw.close();
	}
	
	static class Point implements Comparable<Point>{
		int x,y;
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
	
		@Override
		public int compareTo(Point o) {
			return this.y==o.y?Integer.compare(this.x, o.x):Integer.compare(this.y, o.y);
		}
	}

}
