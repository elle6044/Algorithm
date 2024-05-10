import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[][] map;
	static boolean[][] v;
	
	static int zCnt=0;
	
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
				if(input==0) zCnt++;
			}
		}
		
		Set<Integer> set=new HashSet();
		back(0, set);

		bw.write(answer+"");
		bw.close();
	}
	
	static int answer=0;
	
	static void back(int idx, Set<Integer> set) {
		if(set.size()==3) {
			answer=Math.max(answer, bfs(set));
			return;
		}
		if(idx==N*M) return;
		
		if(map[idx/M][idx%M]==0) {
			set.add(idx);
			back(idx+1,set);
			set.remove(idx);
		}
		back(idx+1,set);
	}
	
	static int bfs(Set<Integer> set) {
		Queue<Point> q=new ArrayDeque();
		v=new boolean[N][M];
		for(int a:set) {
			v[a/M][a%M]=true;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==2) {
					q.offer(new Point(i,j));
					v[i][j]=true;
				}
			}
		}
		
		int cnt=0;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]&&map[nr][nc]==0) {
					q.offer(new Point(nr,nc));
					v[nr][nc]=true;
					cnt++;
				}
			}
		}
		
		return zCnt-cnt-3;
	}
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}

}
