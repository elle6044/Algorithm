import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[][] map;
	static boolean[][] v;
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
	
	static Queue<Point> virus=new ArrayDeque();
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		v=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int input=Integer.parseInt(st.nextToken());
				map[i][j]=input;
				if(input==2) {
					virus.offer(new Point(i,j));
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(i*M+j,1);
					map[i][j]=0;
				}
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}
	
	static int answer=Integer.MIN_VALUE;
	static void dfs(int idx, int cnt) {
		if(cnt==3) {
			bfs();
			answer=Math.max(answer, check());
			return;
		}
		
		for(int i=idx+1;i<N*M;i++) {
			int r=i/M;
			int c=i%M;
			if(map[r][c]==0) {
				map[r][c]=1;
				dfs(i,cnt+1);
				map[r][c]=0;
			}
		}
		
	}
	
	static void bfs() {
		v=new boolean[N][M];
		Queue<Point> q=new ArrayDeque();
		q.addAll(virus);
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==0&&!v[nr][nc]) {
					q.offer(new Point(nr,nc));
					v[nr][nc]=true;
				}
			}
		}
	}
	
	static int check() {
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0&&!v[i][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}
