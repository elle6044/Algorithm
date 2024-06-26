import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,K;
	static long[] array; 
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		array=new long[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i]=Long.parseLong(st.nextToken());
		}
		
		long sum=0;
		for(int i=0;i<K;i++) {
			sum+=array[i];
		}
		long answer=sum;
		
		for(int i=K;i<N+K;i++) {
			sum+=array[i%N]-array[i-K];
			answer=Math.max(answer, sum);
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
