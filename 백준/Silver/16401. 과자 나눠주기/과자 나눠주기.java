import java.util.*;
import java.io.*;
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
		array=new int[M];
		st=new StringTokenizer(br.readLine());
		long max=0;
		for(int i=0;i<M;i++) {
			int a=Integer.parseInt(st.nextToken());
			array[i]=a;
			max=Math.max(max, a);
		}
		
		long high=max;
		long low=1;
		long answer=0;
		
		while(high>=low) {
			long mid=(high+low)/2;
			long cnt=getCnt(mid);
			
			if(cnt>=N) {
				answer=mid;
				low=mid+1;
			}
			else {
				high=mid-1;
			}
		}
		
		bw.write(answer+"");
		bw.close();

	}
	
	static long getCnt(long mid) {
		long cnt=0;
		for(int i=0;i<M;i++) {
			cnt+=array[i]/mid;
		}
		return cnt;
	}

}
