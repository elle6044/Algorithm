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
		long sum=0;
		int max=0;
		for(int i=0;i<N;i++) {
			int a=Integer.parseInt(br.readLine());
			array[i]=a;
			max=Math.max(max, a);
			sum+=a;
		}
		
		long low=1;
		long high=max;
		long answer=0;
		while(high>=low) {
			long mid=(high+low)/2;
			long cnt=getCnt(mid);
			
			if(cnt>=M) {
				answer=mid;
				low=mid+1;
			}
			else {
				high=mid-1;
			}
		}
		sum-=answer*M;
		bw.write(sum+"");
		bw.close();
	}
	
	static long getCnt(long mid) {
		long cnt=0;
		for(int i=0;i<N;i++) {
			cnt+=array[i]/mid;
		}
		return cnt;
	}

}
