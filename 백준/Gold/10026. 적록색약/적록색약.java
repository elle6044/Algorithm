import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N;
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
	
	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<N;j++) {
				char word=input.charAt(j);
				int num=2;
				if(word=='R') {
					num=1;
				}
				else if(word=='G') {
					num=3;
				}
				map[i][j]=num;
			}
		}
		
		int[] answer=new int[2];
		
		for(int t=0;t<2;t++) {
			v=new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!v[i][j]) {
						bfs(i,j,map[i][j]);
						answer[t]++;
					}
				}
			}
		}
		
		bw.write(answer[0]+" "+answer[1]);
		bw.close();
	}
	
	static void bfs(int r, int c, int color) {
		Queue<Point>q=new ArrayDeque();
		q.offer(new Point(r,c));
		v[r][c]=true;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			map[p.r][p.c]%=2;
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc]==color&&!v[nr][nc]) {
					q.offer(new Point(nr,nc));
					v[nr][nc]=true;
				}
			}
		}
	}
}
