import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,L;
	static int[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int answer=0;
		v=new boolean[N][N];
		L:for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				int pre=map[i][j];
				int next=map[i][j+1];
				
				if(Math.abs(pre-next)>=2) continue L;
				
				if(pre>next) {
					for(int l=1;l<=L;l++) {
						int nj=j+l;
						if(nj>=N||map[i][nj]!=next) {
							continue L;
						}
					}
					
					v[i][j+L]=true;
					j+=L-1;
				}
				else if(pre<next) {
					for(int l=1;l<=L;l++) {
						int nj=j+1-l;
						if(nj<0||map[i][nj]!=pre||v[i][nj]) {
							continue L;
						}
					}
				}
			}
			answer++;
		}
		
		v=new boolean[N][N];
		L:for(int j=0;j<N;j++) {
			for(int i=0;i<N-1;i++) {
				int pre=map[i][j];
				int next=map[i+1][j];
				
				if(Math.abs(pre-next)>=2) continue L;
				
				if(pre>next) {
					for(int l=1;l<=L;l++) {
						int ni=i+l;
						if(ni>=N||map[ni][j]!=next) {
							continue L;
						}
					}
					
					v[i+L][j]=true;
					i+=L-1;
				}
				else if(pre<next) {
					for(int l=1;l<=L;l++) {
						int ni=i+1-l;
						if(ni<0||map[ni][j]!=pre||v[ni][j]) {
							continue L;
						}
					}
				}
			}
			answer++;
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
