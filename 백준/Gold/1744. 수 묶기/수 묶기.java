import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] array=new int[N];
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);
		
		if(N>=2) {
			int[] dp=new int[N];
			dp[0]=array[0];
			dp[1]=Math.max(array[0]*array[1], array[0]+array[1]);
			
			for(int i=2;i<N;i++) {
				dp[i]=Math.max(dp[i-1]+array[i], dp[i-2]+array[i-1]*array[i]);
			}
			
			bw.write(dp[N-1]+"");
		}
		else {
			bw.write(array[0]+"");
		}
		bw.close();
		
		
	}

}
