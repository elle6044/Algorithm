import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		long a=Long.parseLong(st.nextToken());
		long b=Long.parseLong(st.nextToken());
		
		long gcd=getGCD(a,b);
		long answer=a*b/gcd;
		bw.write(answer+"");
		bw.close();
	}
	
	static long getGCD(long a, long b) {
		if(a%b==0) {
			return b;
		}
		return getGCD(b,a%b);
	}

}
