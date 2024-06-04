import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int P=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Point> pq=new PriorityQueue();
		for(int i=0;i<P;i++) {
			st=new StringTokenizer(br.readLine());
			int l=Integer.parseInt(st.nextToken());
			String n=st.nextToken();
			
			Queue<Point> temp=new ArrayDeque();
			boolean check=false;
			while(!pq.isEmpty()) {
				Point p=pq.poll();
				temp.add(p);
				if(p.l-10<=l&&p.l+10>=l&&p.p.size()<M) {
					p.p.put(n, l);
					check=true;
					break;
				}
				
			}
			pq.addAll(temp);
			if(!check) {
				Point np=new Point(i,l);
				np.p.put(n, l);
				pq.add(np);
			}
		}
		while(!pq.isEmpty()) {
			Point p=pq.poll();
			if(p.p.size()==M) {
				bw.write("Started!\n");
			}
			else {
				bw.write("Waiting!\n");
			}
			
			for(String key:p.p.keySet()) {
				bw.write(p.p.get(key)+" "+key+"\n");
			}
		}
		
		bw.close();

	}
	
	static class Point implements Comparable<Point>{
		int t;
		int l;
		Map<String, Integer> p=new TreeMap();
		public Point(int t, int l) {
			this.t=t;
			this.l=l;
		}
		
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.t, o.t);
		}
	}

}
