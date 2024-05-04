import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[N+1][3];
		int[][] dp=new int[N+1][3];
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				dp[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=2;i<=N;i++) {
			dp[i][0]+=Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][2]+=Math.min(dp[i-1][0], dp[i-1][1]);
			dp[i][1]+=Math.min(dp[i-1][0], dp[i-1][2]);
		}
		
		int min=Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			min=Math.min(min, dp[N][i]);
		}
		
		bw.write(min+"");
		bw.close();

	}

}
