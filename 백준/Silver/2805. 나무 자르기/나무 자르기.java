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
		
		int max=0;
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int a=Integer.parseInt(st.nextToken());
			array[i]=a;
			max=Math.max(max, a);
		}
		
		int low=0;
		int high=max;
		
		int answer=0;
		while(low<=high) {
			int mid=(low+high)/2;
			long sum=getSum(mid);
			
			if(sum==M) {
				high=mid;
				break;
			}
			else if(sum>M) {
				low=mid+1;
			}
			else if(sum<M) {
				high=mid-1;
			}
		}
		bw.write(high+"");
		bw.close();
	}
	
	static long getSum(int mid) {
		long sum=0;
		for(int i=0;i<N;i++) {
			if(array[i]>mid) {
				sum+=array[i]-mid;
			}
			
		}
		return sum;
	}

}
