import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		
		int[] array=new int[N];
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		int answer=0;
		int sum=0;
		for(int i=0;i<K;i++) {
			sum+=array[i];
		}
		
		answer=sum;
		for(int i=K;i<N;i++) {
			sum-=array[i-K];
			sum+=array[i];
			answer=Math.max(answer, sum);
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
