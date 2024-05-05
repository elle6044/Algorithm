import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		
		long[] dp=new long[N+3];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		for(int i=4;i<=N;i++) {
			dp[i]=dp[i-1]+dp[i-3];
		}
		
		bw.write(dp[N]+"");
		bw.close();
	}

}
