import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Point> gem=new PriorityQueue(com1);
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			gem.offer(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		PriorityQueue<Integer> C=new PriorityQueue();
		for(int i=0;i<K;i++) {
			C.offer(Integer.parseInt(br.readLine()));
		}
		
		PriorityQueue<Point> temp=new PriorityQueue(com2);
		
		long sum=0;
		int cnt=0;
		int c=C.poll();
		while(!gem.isEmpty()) {
			Point p=gem.poll();
			if(p.m<=c) {
				temp.offer(p);
			}
			else {
				if(!temp.isEmpty()) {
					sum+=temp.poll().v;
				}
				
				cnt++;
				gem.offer(p);
				if(cnt==K) break;
				c=C.poll();
			}
		}
		
		for(int i=0;i<K-cnt;i++) {
			if(!temp.isEmpty()) {
				sum+=temp.poll().v;
			}
		}
		
		
		bw.write(sum+"");
		bw.close();

	}
	
	static class Point{
		int m,v;
		public Point(int m, int v) {
			this.m=m;
			this.v=v;
		}
	}
	
	static Comparator<Point> com1=new Comparator<Point>() {
		@Override
		public int compare(Point o1, Point o2) {
			return o1.m==o2.m?Integer.compare(o2.v, o1.v):Integer.compare(o1.m, o2.m);

		}
	};

	static Comparator<Point> com2=new Comparator<Point>() {
		@Override
		public int compare(Point o1, Point o2) {
			return Integer.compare(o2.v, o1.v);

		}
	};
}
