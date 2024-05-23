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
		int max=0;
		for(int i=0;i<M;i++) {
			int a=Integer.parseInt(br.readLine());
			array[i]=a;
			max=Math.max(max, a);
		}
		
		long high=max;
		long low=1;
		long answer=0;
		
		while(high>=low) {
			long mid=(high+low)/2;
			long cnt=getCnt(mid);
			
			if(cnt>N) {
				low=mid+1;
			}
			else {
				answer=mid;
				high=mid-1;
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}
	
	static long getCnt(long mid) {
		long cnt=0;
		for(int i=0;i<M;i++) {
			cnt+=array[i]/mid+(array[i]%mid==0?0:1);
		}
		return cnt;
	}

}
