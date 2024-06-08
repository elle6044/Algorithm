import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[][] map;
	static boolean[][] v;
	
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		v=new boolean[N][M];
		
		int sr=0;
		int sc=0;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int a=Integer.parseInt(st.nextToken());
				map[i][j]=a;
				if(a==2) {
					sr=i;
					sc=j;
				}
			}
		}
		
		bfs(sr,sc);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1&&!v[i][j]) {
					map[i][j]=-1;
				}
				bw.write(map[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.close();
	}

	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static class Point{
		int r, c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
	
	static void bfs(int sr, int sc) {
		Queue<Point> q=new ArrayDeque();
		q.offer(new Point(sr,sc));
		v[sr][sc]=true;
		
		int cnt=0;
		while(!q.isEmpty()) {
			int size=q.size();
			for(int s=0;s<size;s++) {
				Point p=q.poll();
				map[p.r][p.c]=cnt;
				for(int d=0;d<4;d++) {
					int nr=p.r+dr[d];
					int nc=p.c+dc[d];
					if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]&&map[nr][nc]>0) {
						q.offer(new Point(nr,nc));
						v[nr][nc]=true;
						
					}
				}
			}
			cnt++;
		}
	}
}
