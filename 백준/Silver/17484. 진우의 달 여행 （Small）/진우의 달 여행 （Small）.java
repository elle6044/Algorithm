import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[][] array;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		array=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				array[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int j=0;j<M;j++) {
			back(0,j,array[0][j],-1);
		}
		
		bw.write(answer+"");
		bw.close();
	}
	static int[] dr= {1,1,1};
	static int[] dc={-1,0,1};
	static int answer=Integer.MAX_VALUE;
	
	static void back(int i, int j, int sum, int dir) {
		for(int d=0;d<3;d++) {
			if(dir==d) continue;
			int nr=i+dr[d];
			int nc=j+dc[d];
			if(nc>=0&&nc<M) {
				if(nr<N) {
					back(nr,nc,sum+array[nr][nc],d);
				}
				else {
					answer=Math.min(answer, sum);
				}
			}
		}
	}

}
