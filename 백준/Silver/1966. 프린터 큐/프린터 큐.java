import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			Queue<Point> q=new ArrayDeque();
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				q.offer(new Point(i,Integer.parseInt(st.nextToken())));
			}
			
			int cnt=1;
			L:while(true) {
				int max=0;
				for(Point p:q) {
					max=Math.max(max, p.num);
				}
				int size=q.size();
				for(int i=0;i<size;i++) {
					Point p=q.poll();
					if(p.num<max) {
						q.offer(p);
					}
					else {
						if(M==p.idx) break L;
						cnt++;
						break;
					}
				}
			}
			bw.write(cnt+"\n");
		}
		bw.close();

	}
	
	static class Point{
		int idx, num;
		public Point(int idx, int num) {
			this.idx=idx;
			this.num=num;
		}
	}

}
