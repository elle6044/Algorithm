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
		array=new long[N+1];
		st=new StringTokenizer(br.readLine());
		long answer=0;
		for(int i=1;i<=N;i++) {
			long input=Long.parseLong(st.nextToken());
			array[i]=array[i-1]+input;
			answer+=array[i-1]*input;
		}
		bw.write(answer+"");
		bw.close();
	}

}
