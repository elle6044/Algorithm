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
			pq.offer(new Point(i,Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		
		while(!pq.isEmpty()) {
			Point p=pq.poll();
			bw.write(p.num+" "+p.name+"\n");
		}
		bw.close();

	}
	
	static class Point{
		int idx,num;
		String name;
		public Point(int idx, int num, String name) {
			this.idx=idx;
			this.num=num;
			this.name=name;
		}
	}
	
	static Comparator<Point> com=new Comparator<Point>(){
		
		@Override
		public int compare(Point o1, Point o2) {
			if(o1.num!=o2.num) {
				return Integer.compare(o1.num, o2.num);
			}
			else {
				return Integer.compare(o1.idx, o2.idx);
			}
		}
	};

}
