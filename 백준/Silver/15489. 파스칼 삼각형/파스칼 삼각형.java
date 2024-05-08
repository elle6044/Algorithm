import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int R=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		int W=Integer.parseInt(st.nextToken());
		
		int[][]dp=new int[31][31];
		for(int i=0;i<31;i++) {
			Arrays.fill(dp[i], 1);
		}
		
		for(int i=3;i<31;i++) {
			for(int j=1;j<i-1;j++) {
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
			}
		}
		
		int answer=0;
		for(int i=R;i<R+W;i++) {
			for(int j=0;j<=i-R;j++) {
				answer+=dp[i][C+j-1];
			}
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
