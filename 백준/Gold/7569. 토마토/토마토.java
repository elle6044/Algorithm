import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M,H;
	static int[][][] map;
	static boolean[][][] v;
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	static int[] dh= {1,-1};
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		map=new int[H][N][M];
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				st=new StringTokenizer(br.readLine());
				
				for(int k=0;k<M;k++) {
					int input=Integer.parseInt(st.nextToken());
					map[i][j][k]=input;
					if(input==0) cnt++;
				}
			}
		}
		
		bfs();
		
		if(cnt==0) bw.write(answer+"");
		else bw.write("-1");
		
		bw.close();
	}
	
	static int answer=0;
	static int cnt=0;
	
	static void bfs() {
		Queue<Point> q=new ArrayDeque<>();
		v=new boolean[H][N][M];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(map[i][j][k]==1) {
						q.offer(new Point(i,j,k));
						v[i][j][k]=true;
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			int size=q.size();
			boolean isChanged=false;
			
			for(int s=0;s<size;s++) {
				Point p=q.poll();
				
				for(int d=0;d<4;d++) {
					int nr=p.r+dr[d];
					int nc=p.c+dc[d];
					if(nr>=0&&nr<N&&nc>=0&&nc<M&&
							map[p.h][nr][nc]==0&&!v[p.h][nr][nc]) {
						q.offer(new Point(p.h,nr,nc));
						v[p.h][nr][nc]=true;
						map[p.h][nr][nc]=1;
						isChanged=true;
						cnt--;
					}
				}
				
				for(int d=0;d<2;d++) {
					int nh=p.h+dh[d];
					if(nh>=0&&nh<H&&map[nh][p.r][p.c]==0&&!v[nh][p.r][p.c]) {
						q.offer(new Point(nh,p.r,p.c));
						v[nh][p.r][p.c]=true;
						map[nh][p.r][p.c]=1;
						isChanged=true;
						cnt--;
					}
				}
			}
			
			if(isChanged) answer++;
		}
	}
	
	static class Point{
		int h,r,c;
		public Point(int h, int r, int c) {
			this.h=h;
			this.r=r;
			this.c=c;
		}
	}
}
