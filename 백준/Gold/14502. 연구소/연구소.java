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
	
	static List<Point> virusList=new ArrayList<>();
	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
	
	static int emptySize=0;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int input=Integer.parseInt(st.nextToken());
				map[i][j]=input;
				
				if(input==2) {
					virusList.add(new Point(i,j));
				}
				if(input==0) emptySize++;
			}
		}
		
		emptySize-=3;
		
		dfs(0,0);
		
		bw.write(answer+"");
		bw.close();
	}
	
	static int answer=0;
	
	static void dfs(int idx, int cnt) {
		
		
		if(cnt==3) {
			int size=bfs();
			answer=Math.max(answer, size);
			
			return;
		}
		
		if(idx==N*M) return;
		
		int r=idx/M;
		int c=idx%M;
		
		if(map[r][c]==0) {
			map[r][c]=1;
			dfs(idx+1, cnt+1);
			map[r][c]=0;
		}
		dfs(idx+1, cnt);
	}
	
	static int bfs() {
		Queue<Point> q=new ArrayDeque<>();
		v=new boolean[N][M];
		int size=emptySize;
		
		q.addAll(virusList);
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==0&&!v[nr][nc]) {
					q.offer(new Point(nr,nc));
					v[nr][nc]=true;
					size--;
				}
			}
		}
		
		return size;
	}
}
