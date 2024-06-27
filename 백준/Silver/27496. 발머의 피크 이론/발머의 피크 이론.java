import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,L;
	static int[] array;

	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		int answer=0;
		int sum=0;
		for(int i=0;i<L;i++) {
			sum+=array[i];
			if(sum>=129&&sum<=138) answer++;
		}
		
		for(int i=L;i<N;i++) {
			sum+=array[i]-array[i-L];
			if(sum>=129&&sum<=138) answer++;

		}
		
		bw.write(answer+"");
		bw.close();
	}

}
