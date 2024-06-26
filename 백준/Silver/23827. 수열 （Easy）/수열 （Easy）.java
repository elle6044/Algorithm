import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static long[] array;

	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		array=new long[N];
		st=new StringTokenizer(br.readLine());
		long sum=0;
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
			sum+=array[i];
		}
		
		long answer=0;
		for(int i=0;i<N;i++) {
			answer+=(sum-array[i])*array[i];
			answer%=1000000007;
		}
		answer = (answer * 500000004) % 1000000007;
		bw.write(answer+"");
		bw.close();

	}

}
