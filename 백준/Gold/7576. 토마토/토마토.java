
import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[][] map;
	static boolean[][] v;
	
	static Queue<Point> q=new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		v=new boolean[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int input=Integer.parseInt(st.nextToken());
				map[i][j]=input;
				if(input==1) {
					q.offer(new Point(i,j));
					v[i][j]=true;
				}
			}
		}
		
		int answer=bfs();
		
		boolean check=true;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					check=false;
				}
			}
		}
		
		if(check) {
			bw.write(answer+"");
		}
		else {
			bw.write("-1");
		}
		bw.close();
	}
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static int bfs() {
		int cnt=0;
		while(!q.isEmpty()) {
			int size=q.size();
			boolean check=false;

			for(int s=0;s<size;s++) {
				Point p=q.poll();
				for(int d=0;d<4;d++) {
					int nr=p.r+dr[d];
					int nc=p.c+dc[d];
					if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==0&&!v[nr][nc]) {
						q.offer(new Point(nr,nc));
						v[nr][nc]=true;
						map[nr][nc]=1;
						check=true;
					}
				}
			}
			if(check) {
				cnt++;
			}
		}
		return cnt;
	}
	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
}
