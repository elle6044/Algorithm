import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Point>pq=new PriorityQueue(com1);
		PriorityQueue<Point>pq2=new PriorityQueue(com2);
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int v=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			pq.offer(new Point(v,c));
		}
		
		int sum=0;
		int answer=0;
		for(int i=0;i<N;i++) {
			Point p=pq.poll();
			sum+=p.v;
			answer=p.c;
			pq2.offer(p);
		}
		
		while(!pq.isEmpty()&&sum<M) {
			Point p=pq.poll();
			Point p2=pq2.poll();
			sum-=p2.v;
			sum+=p.v;
			answer=p.c;
			pq2.offer(p);
		}
		
		if(sum<M) answer=-1;
		bw.write(answer+"");
		bw.close();
	}
	
	static class Point implements Comparable<Point>{
		int v,c;
		public Point(int v, int c) {
			this.v=v;
			this.c=c;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.c==o.c?o.v-this.v:this.c-o.c;
		}
	}
	
	static Comparator<Point> com1=new Comparator<Point>() {
		
		@Override
		public int compare(Point o1, Point o2) {
			return o1.c==o2.c?o2.v-o1.v:o1.c-o2.c;
		}
	};
	
	static Comparator<Point> com2=new Comparator<Point>() {
		
		@Override
		public int compare(Point o1, Point o2) {
			return o1.v-o2.v;
		}
	};

}
