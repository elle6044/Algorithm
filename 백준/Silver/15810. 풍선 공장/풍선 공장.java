import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static long M;
	static int[] array;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Long.parseLong(st.nextToken());
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		
		long max=0;
		for(int i=0;i<N;i++) {
			int a=Integer.parseInt(st.nextToken());
			array[i]=a;
			max=Math.max(max, a);
		}
		
		long high=max*M;
		long low=1;
		long answer=0;
		while(high>=low) {
			long mid=(high+low)/2;
			long cnt=getCnt(mid);
			
			if(cnt>=M) {
				answer=mid;
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}
	
	static long getCnt(long mid) {
		long cnt=0;
		for(int i=0;i<N;i++) {
			cnt+=mid/array[i];
		}
		return cnt;
	}

}
