import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		int[] array=new int[2*N];
		for(int i=0;i<N*2;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		int answer=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			answer=Math.min(answer, array[2*N-1-i]+array[i]);
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
