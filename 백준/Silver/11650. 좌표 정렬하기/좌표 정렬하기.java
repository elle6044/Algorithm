import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Point> pq=new PriorityQueue(com);
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			pq.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			
		}
		
		while(!pq.isEmpty()) {
			Point p=pq.poll();
			bw.write(p.x+" "+p.y+"\n");
		}
		bw.close();

	}
	
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static Comparator<Point> com=new Comparator<Point>() {
		
		@Override
		public int compare(Point o1, Point o2) {
			if(o1.x!=o2.x) {
				return Integer.compare(o1.x, o2.x);
			}
			else {
				return Integer.compare(o1.y, o2.y);
			}
		}
	};

}
