import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int H=Integer.parseInt(st.nextToken());
		int Y=Integer.parseInt(st.nextToken());
		int[] dp=new int[Y+1];
		dp[0]=H;
		for(int i=1;i<=Y;i++) {
			if(i>=5) {
				dp[i]=Math.max(dp[i], dp[i-5]*135/100);
			}
			if(i>=3) {
				dp[i]=Math.max(dp[i], dp[i-3]*120/100);
			}
			dp[i]=Math.max(dp[i], dp[i-1]*105/100);
		}
		
		bw.write(dp[Y]+"");
		bw.close();
	}

}
