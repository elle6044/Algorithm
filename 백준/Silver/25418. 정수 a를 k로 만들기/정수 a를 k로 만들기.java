import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int[] dp=new int[K+1];
		
		for(int i=A+1;i<=K;i++) {
			dp[i]=i-A;
		}
		
		dp[A]=0;
		dp[A+1]=1;
		
		for(int i=A+1;i<=K;i++) {
			if(i%2==0) {
				if(i/2>=A) {
					dp[i]=Math.min(dp[i],dp[i/2]+1);
				}
			}
			dp[i]=Math.min(dp[i],dp[i-1]+1);
			
		}
		
		bw.write(dp[K]+"");
		bw.close();

	}

}
