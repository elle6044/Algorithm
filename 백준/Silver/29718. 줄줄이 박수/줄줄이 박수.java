import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[] array;

	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		array=new int[M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				array[j]+=Integer.parseInt(st.nextToken());
			}
		}
		int A=Integer.parseInt(br.readLine());
		
		
		int sum=0;
		for(int i=0;i<A;i++) {
			sum+=array[i];
		}
		
		int answer=sum;
		for(int i=A;i<M;i++) {
			sum+=array[i]-array[i-A];
			answer=Math.max(answer, sum);
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
