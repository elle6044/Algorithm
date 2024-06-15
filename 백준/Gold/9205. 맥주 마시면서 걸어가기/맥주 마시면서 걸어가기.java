import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			int sr=Integer.parseInt(st.nextToken());
			int sc=Integer.parseInt(st.nextToken());

			List<Point> list=new ArrayList();
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				int r=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				list.add(new Point(r,c));
			}
			
			st=new StringTokenizer(br.readLine());
			int er=Integer.parseInt(st.nextToken());
			int ec=Integer.parseInt(st.nextToken());
			list.add(new Point(er,ec));
			
			boolean[] v=new boolean[N+1];
			Queue<Point> q=new ArrayDeque();
			q.offer(new Point(sr,sc));
			
			String answer="sad";
			while(!q.isEmpty()) {
				Point p=q.poll();
				if(p.r==er&&p.c==ec) {
					answer="happy";
				}
				for(int i=0;i<=N;i++) {
					if(!v[i]) {
						Point np=list.get(i);
						if(Math.abs(p.r-np.r)+Math.abs(p.c-np.c)<=1000) {
							q.offer(np);
							v[i]=true;
						}
					}
				}
			}
			bw.write(answer+"\n");
			
		}
		bw.close();
	}
	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}

}
