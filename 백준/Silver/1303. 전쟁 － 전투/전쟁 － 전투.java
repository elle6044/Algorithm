import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static char[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		v=new boolean[N][M];
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=input.charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!v[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		bw.write(w+" "+b);
		bw.close();
	}
	
	static int w=0;
	static int b=0;

	static void bfs(int r, int c) {
		Queue<Point> q=new ArrayDeque();
		q.offer(new Point(r,c));
		v[r][c]=true;
		int cnt=1;
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==map[r][c]&&!v[nr][nc]) {
					q.offer(new Point(nr,nc));
					v[nr][nc]=true;
					cnt++;
				}
			}
		}
		if(map[r][c]=='W') {
			w+=cnt*cnt;
		}
		else {
			b+=cnt*cnt;
		}
		
	}
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
}
