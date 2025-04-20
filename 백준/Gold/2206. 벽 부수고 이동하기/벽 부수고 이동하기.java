import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[][] map;
	static boolean[][][] v;
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	static class Point{
		int r,c,w,cnt;
		public Point(int r, int c, int w, int cnt) {
			this.r=r;
			this.c=c;
			this.w=w;
			this.cnt=cnt;
		}
	}
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<M;j++) {
				int num=Character.getNumericValue(input.charAt(j));
				map[i][j]=num;
			}
		}
		
		bfs();
		
		if(answer==Integer.MAX_VALUE) answer=-1;
		
		bw.write(answer+"");
		bw.close();
	}
	
	static int answer=Integer.MAX_VALUE;
	
	static void bfs() throws Exception{
		Queue<Point> q=new ArrayDeque<>();
		v=new boolean[2][N][M];
		
		q.offer(new Point(0,0,0,1));
		v[0][0][0]=true;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(p.r==N-1&&p.c==M-1) {
				answer=Math.min(answer, p.cnt);
			}
			
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				
				if(nr>=0&&nr<N&&nc>=0&&nc<M) {
					if(map[nr][nc]==0) {
						if(!v[p.w][nr][nc]) {
							q.offer(new Point(nr,nc,p.w,p.cnt+1));
							v[p.w][nr][nc]=true;
						}
					}
					else {
						if(p.w==0&&!v[p.w+1][nr][nc]) {
							q.offer(new Point(nr,nc,p.w+1,p.cnt+1));
							v[p.w+1][nr][nc]=true;
						}
					}
				}
			}
		}
	}
}
