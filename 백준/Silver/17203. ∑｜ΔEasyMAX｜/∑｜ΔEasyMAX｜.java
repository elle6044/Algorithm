import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,Q;
	static int[] array;
	static int[] sum;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		array[0]=Integer.parseInt(st.nextToken());
		sum=new int[N];
		for(int i=1;i<N;i++) {
			int a=Integer.parseInt(st.nextToken());
			array[i]=a;
			sum[i]=sum[i-1]+Math.abs(array[i-1]-a);
		}
		
		for(int i=0;i<Q;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int answer=sum[e]-sum[s];
			bw.write(answer+"\n");
		}
		bw.close();

	}

}
