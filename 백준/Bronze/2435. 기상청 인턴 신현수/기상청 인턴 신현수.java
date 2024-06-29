import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,K;
	static int[] array;
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		int sum=0;
		for(int i=0;i<K;i++) {
			sum+=array[i];
		}
		int answer=sum;
		for(int i=K;i<N;i++) {
			sum+=array[i]-array[i-K];
			answer=Math.max(answer, sum);
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
