import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static long[] sum;

	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		sum=new long[M+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=M;i++) {
			sum[i]=sum[i-1]+Long.parseLong(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			long target=Long.parseLong(br.readLine());
			if(target>sum[M]) {
				bw.write("Go away!\n");
				continue;
			}
			
			int low=1;
			int high=M;
			int cnt=0;
			while(low<=high) {
				int mid=(low+high)/2;
				long temp=sum[mid];
				
				if(temp>=target) {
					cnt=mid;
					high=mid-1;
				}
				else {
					low=mid+1;
				}
			}
			
			bw.write(cnt+"\n");
		}
		bw.close();
	}

}
