import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	
	static int[] dr= {2,-2,1,-1};
	static int[] dc= {1,1,2,2};
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		
		if(N<3||M<7) {
			dfs(0,0,1);
			answer=Math.min(answer, 4);
		}
		else {
			answer=4;
			answer+=M-6;
		}
		
		bw.write(answer+"");
		bw.close();
	}
	
	static int answer=0;
	static void dfs(int r, int c, int cnt) {
		answer=Math.max(answer, cnt);
        if(cnt==4) return;
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<M) {
				dfs(nr,nc,cnt+1);
			}
		}
	}
}
