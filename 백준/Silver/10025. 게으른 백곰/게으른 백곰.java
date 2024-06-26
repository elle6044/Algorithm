import java.io.*;
import java.util.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,K;
	static int[] array=new int[1000002];
	static int[] sum=new int[1000002];
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());

		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int g=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken())+1;
			array[x]=g;
		}
		
		sum[0]=array[0];
		for(int i=1;i<1000002;i++) {
			sum[i]=sum[i-1]+array[i];
		}
		
		long answer=0;
		for(int i=0;i<1000002;i++) {
			answer=Math.max(answer, sum[Math.min(1000001, i+K)]-sum[Math.max(0, i-K-1)]);
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
