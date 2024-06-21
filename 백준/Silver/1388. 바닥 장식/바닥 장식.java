import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static char[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		v=new boolean[N][M];
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=input.charAt(j);
			}
		}
		
		int answer=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!v[i][j]) {
					bfs(i,j);
					answer++;
				}
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}

	static void bfs(int r, int c) {
		char start=map[r][c];
		int dir=start=='-'?0:1;
		
		Queue<Point> q=new ArrayDeque();
		q.offer(new Point(r,c));
		v[r][c]=true;
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int d=0;d<2;d++) {
				int nr=p.r+dr[dir][d];
				int nc=p.c+dc[dir][d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==start&&!v[nr][nc]) {
					q.offer(new Point(nr,nc));
					v[nr][nc]=true;
				}
			}
		}
	}
	
	static int[][] dr= {{0,0},{1,-1}};
	static int[][] dc= {{1,-1},{0,0}};
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
}
