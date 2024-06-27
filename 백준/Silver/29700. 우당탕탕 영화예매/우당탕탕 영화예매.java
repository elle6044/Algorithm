import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M,K;
	static int[][] array;

	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		int answer=0;
		if(M>=K) {
			array=new int[N][M];
			for(int i=0;i<N;i++) {
				String input=br.readLine();
				for(int j=0;j<M;j++) {
					int a=input.charAt(j)-48;
					array[i][j]=a;
				}
			}
			
			int[] sum=new int[N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<K;j++) {
					sum[i]+=array[i][j];
				}
				if(sum[i]==0) answer++;
			}
			
			for(int j=K;j<M;j++) {
				for(int i=0;i<N;i++) {
					sum[i]+=array[i][j]-array[i][j-K];
					if(sum[i]==0) answer++;
				}
			}
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
