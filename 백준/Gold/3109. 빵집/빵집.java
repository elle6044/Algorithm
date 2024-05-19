import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static char[][] map;
	static boolean[][] v;
	
	static int[] dr= {-1,0,1};
	static int[] dc= {1,1,1};
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new char[N][M];
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=input.charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			if(map[i][0]=='.') {
				check=false;
				dfs(i,0);
			}
		}
		
		bw.write(answer+"");
		bw.close();

	}
	
	static boolean check;
	static int answer=0;
	static void dfs(int r, int c) {
		if(c==M-1) {
			check=true;
			answer++;
			return;
		}
		
		for(int d=0;d<3;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]=='.') {
				map[nr][nc]='x';
				dfs(nr,nc);
				if(check) return;
			}
		}
	}

}
