import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,Q;
	static int[] array;
	static int[] sum;
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		sum=new int[N+1];
		sum[1]=array[0];
		for(int i=1;i<N;i++) {
			sum[i+1]=sum[i]+array[i];
		}
		
		for(int i=0;i<Q;i++) {
			st=new StringTokenizer(br.readLine());
			int l=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			bw.write(sum[r]-sum[l-1]+"\n");
		}
		bw.close();

	}

}
