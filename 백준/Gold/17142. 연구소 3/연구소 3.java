import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[][] map;
	static boolean[][] v;
	
	static List<Integer> virus=new ArrayList();
	static int[] array;
	static int zero=0;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		array=new int[M];
		
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int input=Integer.parseInt(st.nextToken());
				map[i][j]=input;
				if(input==0){
					zero++;
				}
				else if(input==2) {
					virus.add(i*N+j);
				}
			}
		}
		
		back(0,0);
		
		if(min==Integer.MAX_VALUE) {
			min=-1;
		}
		
		bw.write(min+"");
		bw.close();
	}
	
	static int min=Integer.MAX_VALUE;
	
	static void back(int cnt, int idx) {
		if(cnt==M) {
			int time=bfs();
			min=Math.min(min, time);
			return;
		}
		if(idx==virus.size()) return;
		
		array[cnt]=virus.get(idx);
		back(cnt+1,idx+1);
		
		back(cnt,idx+1);
		
	}
	
	static int bfs() {
		Queue<Point>q=new ArrayDeque();
		v=new boolean[N][N];
		int time=0;
		int cnt=0;
		for(int a:array) {
			q.offer(new Point(a/N,a%N));
			v[a/N][a%N]=true;
		}
		
		while(!q.isEmpty()) {
			if(cnt==zero) break;
			int size=q.size();
			for(int s=0;s<size;s++) {
				Point p=q.poll();
				for(int d=0;d<4;d++) {
					int nr=p.r+dr[d];
					int nc=p.c+dc[d];
					if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]) {
						if(map[nr][nc]==0) {
							cnt++;
							q.offer(new Point(nr, nc));
							v[nr][nc]=true;
						}
						else if(map[nr][nc]==2) {
							q.offer(new Point(nr, nc));
							v[nr][nc]=true;
						}
						
					}
				}
			}
			time++;
			
		}
		
		if(cnt<zero) time=Integer.MAX_VALUE;
		return time;
	}
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static class Point{
		int r, c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
}
