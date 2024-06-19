import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		long N=Long.parseLong(st.nextToken());
		long L=Long.parseLong(st.nextToken());
		long W=Long.parseLong(st.nextToken());
		long H=Long.parseLong(st.nextToken());
		
		double low=0;
		double high=Math.min(L, Math.min(W, H));
		
		double answer=0;
		int temp=0;
		while(low<high) {
			double mid=(low+high)/2;
			long cnt=((long)(L/mid))*((long)(W/mid))*((long)(H/mid));
			
			if(cnt>=N) {
				answer=mid;
				low=mid;
			}
			else {
				high=mid;
			}
			temp++;
			
			if(temp>5000) break;
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
