import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int max=Math.max(N, M);
		int min=Math.min(N, M);
		
		int[][]map=new int[N][M];
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=input.charAt(j)-48;
			}
		}
		
		int answer=1;
		for(int s=2;s<=min;s++) {
			for(int i=0;i<=N-s;i++) {
				for(int j=0;j<=M-s;j++) {
					int num=map[i][j];
					if(num==map[i+s-1][j]&&num==map[i][j+s-1]&&num==map[i+s-1][j+s-1]) {
						answer=s;
					}
				}
			}
		}
		
		bw.write(answer*answer+"");
		bw.close();
	}

}
