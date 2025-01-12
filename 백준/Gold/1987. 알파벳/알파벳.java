import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,M;
	static int[][] map;
	static boolean[] v=new boolean[26];
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M]; 
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<M;j++) {
				char word=input.charAt(j);
				map[i][j]=(int)word - 65;
			}
		}
		
		v[map[0][0]]=true;
		dfs(0,0,1);
		
		bw.write(answer+"");
		bw.close();
		
	}
	
	static int answer=Integer.MIN_VALUE;
	
	static void dfs(int r, int c, int cnt) {
		answer=Math.max(answer, cnt);
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<M&&!v[map[nr][nc]]) {
				v[map[nr][nc]]=true;
				dfs(nr, nc, cnt+1);
				v[map[nr][nc]]=false;
			}
		}
	}
	

}
