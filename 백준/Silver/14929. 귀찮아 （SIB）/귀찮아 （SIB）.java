import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int[] array;
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		
		int sum=0;
		for(int i=0;i<N;i++) {
			int a=Integer.parseInt(st.nextToken());
			array[i]=a;
			sum+=a;
		}
		
		long answer=0;
		for(int i=0;i<N;i++) {
			int a=array[i];
			answer+=(sum-a)*a;
		}
		
		bw.write(answer/2+"");
		bw.close();

	}

}
