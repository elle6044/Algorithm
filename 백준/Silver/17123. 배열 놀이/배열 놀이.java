import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[][] array;
	static int[] sumr;
	static int[] sumc;

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			array=new int[N+1][N+1];
			sumr=new int[N+1];
			sumc=new int[N+1];
			for(int i=1;i<=N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++) {
					int input=Integer.parseInt(st.nextToken());
					array[i][j]=input;
				}
			}
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					sumc[i]+=array[i][j];
					sumr[i]+=array[j][i];
				}
			}
			
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int r1=Integer.parseInt(st.nextToken());
				int c1=Integer.parseInt(st.nextToken());
				int r2=Integer.parseInt(st.nextToken());
				int c2=Integer.parseInt(st.nextToken());
				int v=Integer.parseInt(st.nextToken());
				
				int gapr=r2-r1+1;
				int gapc=c2-c1+1;
				for(int r=r1;r<=r2;r++) {
					sumc[r]+=v*gapc;
				}
				
				for(int c=c1;c<=c2;c++) {
					sumr[c]+=v*gapr;
				}
			}
			
			
			
			for(int i=1;i<=N;i++) {
				bw.write(sumc[i]+" ");
			}
			bw.write("\n");
			
			for(int i=1;i<=N;i++) {
				bw.write(sumr[i]+" ");
			}
			bw.write("\n");
		}
		
		bw.close();
	}

}
