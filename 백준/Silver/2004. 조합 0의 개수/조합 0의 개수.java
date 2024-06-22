import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		long n=Long.parseLong(st.nextToken());
		long m=Long.parseLong(st.nextToken());
		
		long answer=0;
		
		long two=cntTwo(n)-cntTwo(m)-cntTwo(n-m);
		long five=cntFive(n)-cntFive(m)-cntFive(n-m);
		
		answer=Math.min(two, five);
		bw.write(answer+"");
		bw.close();
	}
	
	static long cntTwo(long n) {
		long cnt=0;
		for(long i=2;i<=n;i*=2) {
			cnt+=n/i;
		}
		return cnt;
	}
	
	static long cntFive(long n) {
		long cnt=0;
		for(long i=5;i<=n;i*=5) {
			cnt+=n/i;
		}
		return cnt;
	}

}
