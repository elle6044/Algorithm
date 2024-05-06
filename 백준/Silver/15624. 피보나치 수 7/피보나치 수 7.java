import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] dp=new int[N+2];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=N;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%1000000007;
		}
		
		bw.write(dp[N]+"");
		bw.close();
	}

}
