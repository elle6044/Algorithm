import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static long[] array;

	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		array=new long[N+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			array[i]=array[i-1]+Long.parseLong(st.nextToken());
		}
		
		long answer=0;
		for(int i=M;i<=N;i++) {
			answer=Math.max(answer, array[i]-array[i-M]);
		}
		bw.write(answer+"");
		bw.close();
		
	}

}
