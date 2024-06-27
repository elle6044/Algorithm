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
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			for(int j=0;j<M;j++) {
				array[i]+=Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(array);
		
		long answer=0;
		for(int i=0;i<N;i++) {
			answer+=array[i]*(N-i);
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
