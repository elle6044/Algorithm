import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[][] map;
	static boolean[][] v;
	
	static int sr,sc,er,ec;

	public static void main(String[] args) throws Exception{
		for(int t=1;t<=10;t++) {
			int T=Integer.parseInt(br.readLine());
			map=new int[100][100];
			v=new boolean[100][100];
			for(int i=0;i<100;i++) {
				String input=br.readLine();
				for(int j=0;j<100;j++) {
					int num=input.charAt(j)-48;
					map[i][j]=num;
					if(num==2) {
						sr=i;
						sc=j;
					}
					else if(num==3) {
						er=i;
						ec=j;
					}
				}
			}
			
			int answer=0;
			if(bfs()) {
				answer=1;
			}
			
			bw.write("#"+T+" "+answer+"\n");
		}
		bw.close();
	}

	static boolean bfs() {
		Queue<Point> q=new ArrayDeque();
		q.offer(new Point(sr,sc));
		v[sr][sc]=true;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(p.r==er&&p.c==ec) {
				return true;
			}
			
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<100&&nc>=0&&nc<100&&!v[nr][nc]&&map[nr][nc]!=1) {
					q.offer(new Point(nr,nc));
					v[nr][nc]=true;
				}
			}
		}
		return false;
	}
	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
}
