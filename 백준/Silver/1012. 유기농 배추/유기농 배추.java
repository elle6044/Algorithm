
import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int T,N,M,K;
	static int[][] map;
	static boolean[][] v;
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			map=new int[N][M];
			v=new boolean[N][M];
			
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine());
				int c=Integer.parseInt(st.nextToken());
				int r=Integer.parseInt(st.nextToken());
				map[r][c]=1;
			}
			
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1&&!v[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			bw.write(cnt+"\n");
		}
		bw.close();
	}
	
	public static void bfs(int r, int c) {
		Queue<Point> q=new ArrayDeque<>();
		q.offer(new Point(r,c));
		v[r][c]=true;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==1&&!v[nr][nc]) {
					q.offer(new Point(nr,nc));
					v[nr][nc]=true;
				}
			}
		}
	}
	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}

}
