import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		PriorityQueue<Point> pq=new PriorityQueue();
		for(int i=1;i<=8;i++) {
			pq.offer(new Point(i,Integer.parseInt(br.readLine())));
		}
		
		int sum=0;
		Set<Integer> set=new TreeSet();
		for(int i=0;i<5;i++) {
			Point p=pq.poll();
			sum+=p.num;
			set.add(p.idx);
		}
		
		bw.write(sum+"\n");
		for(int a:set) {
			bw.write(a+" ");
		}
		bw.close();
	}
	
	static class Point implements Comparable<Point>{
		int idx, num;
		public Point(int idx, int num) {
			this.idx=idx;
			this.num=num;
		}
		
		@Override
		public int compareTo(Point o) {
			return Integer.compare(o.num, this.num);
		}
	}

}
