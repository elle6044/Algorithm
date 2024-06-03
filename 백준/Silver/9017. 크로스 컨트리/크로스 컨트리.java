import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			int[] array=new int[N];
			Map<Integer, Integer> map=new HashMap();
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int team=Integer.parseInt(st.nextToken());
				array[i]=team;
				map.put(team, map.getOrDefault(team, 0)+1);
			}
			
			Map<Integer, Point> points=new HashMap();
			int rank=1;
			for(int i=0;i<N;i++) {
				int team=array[i];
				if(map.get(team)==6) {
					Point p=points.getOrDefault(team, new Point());
					if(p.cnt==4) {
						p.five=rank;
					}
					else if(p.cnt<=3) {
						p.sum+=rank;
					}
					rank++;
					p.cnt++;
					points.put(team, p);
				}
			}
			
			int min=Integer.MAX_VALUE;
			int idx=0;
			for(int key:points.keySet()) {
				Point p=points.get(key);
				if(min>p.sum) {
					min=p.sum;
					idx=key;
				}
				else if(min==p.sum) {
					if(points.get(idx).five>p.five) {
						min=p.sum;
						idx=key;
					}
				}
			}
			bw.write(idx+"\n");
		}
		bw.close();

	}
	
	static class Point implements Comparable<Point>{
		int cnt=0, sum=0, five=0;
		public Point() {};
		
		@Override
		public int compareTo(Point o) {
			return this.sum==o.sum?Integer.compare(this.five, o.five):Integer.compare(this.sum, o.sum);
		}
	}

}
