import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static long[] array;
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		array=new long[N+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			array[i]=array[i-1]+Long.parseLong(st.nextToken());
		}
		M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			long answer=array[e]-array[s-1];
			bw.write(answer+"\n");
		}
		bw.close();

	}

}
