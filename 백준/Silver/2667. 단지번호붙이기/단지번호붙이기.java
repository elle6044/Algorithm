
import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<N;j++) {
				char word=input.charAt(j);
				map[i][j]=Character.getNumericValue(word);
			}
		}
		
		int answer=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					answer++;
					pq.offer(bfs(i,j));
				}
			}
		}
		
		bw.write(answer+"\n");
		while(!pq.isEmpty()) {
			bw.write(pq.poll()+"\n");
		}
		bw.close();
	}
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static int bfs(int r, int c) {
		int cnt=1;
		Queue<Point> q=new ArrayDeque();
		q.offer(new Point(r,c));
		map[r][c]=0;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc]==1) {
					q.offer(new Point(nr,nc));
					map[nr][nc]=0;
					cnt++;
				}
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
