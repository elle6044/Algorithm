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
		int r,c,wall,cost;
		public Point(int r, int c, int wall, int cost) {
			this.r=r;
			this.c=c;
			this.wall=wall;
			this.cost=cost;
		}
	}
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		v=new boolean[2][N][M];
		
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<M;j++) {
				char word=input.charAt(j);
				map[i][j]=Character.getNumericValue(word);	
			}
		}
		
		bfs();
		
		bw.write((answer==Integer.MAX_VALUE?-1:answer)+"");
		bw.close();
	}
	
	static int answer=Integer.MAX_VALUE;
	
	static void bfs() {
		Queue<Point> q=new ArrayDeque();
		q.offer(new Point(0,0,0,1));
		v[0][0][0]=true;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(p.r==N-1&&p.c==M-1) {
				answer=Math.min(answer, p.cost);
			}
			
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[p.wall][nr][nc]) {
					if(map[nr][nc]==0) {
						q.offer(new Point(nr,nc,p.wall,p.cost+1));
						v[p.wall][nr][nc]=true;
					}
					else {
						if(p.wall==0) {
							q.offer(new Point(nr,nc,p.wall+1,p.cost+1));
							v[p.wall+1][nr][nc]=true;
						}
					}
				}
			}
		}
	}
}
