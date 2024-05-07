import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] dp=new int[N+2];
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=N;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%10;
		}
		
		bw.write(dp[N]+"");
		bw.close();

	}

}
