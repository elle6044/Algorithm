import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int R,C;
	static char[][]map;
	static boolean[][]v;
	
	static int dr[]= {1,-1,0,0};
	static int dc[]= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		v=new boolean[R][C];
		
		int sr=0;
		int sc=0;
		
		for(int r=0;r<R;r++) {
			String word=br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c]=word.charAt(c);
				if(map[r][c]=='J') {
					sr=r;
					sc=c;
				}
			}
		}
		bfs();
		
		if(mincnt==0) {
			bw.write("IMPOSSIBLE");
		}
		else {
			bw.write(mincnt+"");
		}
		bw.close();
		

	}
	static int mincnt=Integer.MAX_VALUE;
	
	static class Point{
		int r,c,cnt;
		char name;

		public Point(int r, int c, int cnt, char name) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.name = name;
		}
	}

	private static void bfs() throws IOException {
		Queue<Point> q=new LinkedList();
		int cnt=0;
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]=='F') {
					v[r][c]=true;
					q.offer(new Point(r,c,0,'F'));
				}
			}
		}
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]=='J') {
					v[r][c]=true;
					q.offer(new Point(r,c,0,'J'));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			
			if(p.name=='J'&&(p.r==0||p.r==R-1||p.c==0||p.c==C-1)) {
				mincnt=Math.min(mincnt, p.cnt+1);
				return;
			}
			
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				
				if(p.name=='F') {
					if(nr>=0&&nr<R&&nc>=0&&nc<C&&v[nr][nc]==false&&map[nr][nc]=='.') {
						v[nr][nc]=true;
						map[nr][nc]='F';
						q.add(new Point(nr,nc,p.cnt+1,'F'));
					}
				}
				else if(p.name=='J') {
					if(nr>=0&&nr<R&&nc>=0&&nc<C&&v[nr][nc]==false&&map[nr][nc]=='.') {
						v[nr][nc]=true;
						map[nr][nc]='J';
						q.add(new Point(nr,nc,p.cnt+1,'J'));
					}
				}
			}	
		}
		mincnt=0;
	}
}