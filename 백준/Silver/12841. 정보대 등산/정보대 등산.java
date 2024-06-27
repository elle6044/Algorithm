import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[] array;
	static long[] suml;
	static long[] sumr;

	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		array=new int[N+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		suml=new long[N];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<N;i++) {
			suml[i]=suml[i-1]+Long.parseLong(st.nextToken());
		}
		
		sumr=new long[N];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<N;i++) {
			sumr[i]=sumr[i-1]+Long.parseLong(st.nextToken());
		}
		
		
		long answer=Long.MAX_VALUE;
		int idx=0;
		
		for(int i=1;i<=N;i++) {
			long left=suml[i-1];
			int mid=array[i];
			long right=sumr[N-1]-sumr[i-1];
			long sum=left+mid+right;
			if(sum<answer) {
				answer=sum;
				idx=i;
			}
		}
		
		bw.write(idx+" "+answer);
		bw.close();
		
		

	}

}
