import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[] array;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		array=new int[N+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			array[i]=array[i-1]+Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int answer=array[e]-array[s-1];
			bw.write(answer+"\n");
		}
		bw.close();

	}

}
