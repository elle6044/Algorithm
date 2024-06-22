import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		
		int r1=Integer.parseInt(st.nextToken());
		for(int i=0;i<N-1;i++) {
			int r2=Integer.parseInt(st.nextToken());
			int gcd=getGCD(r1,r2);
			int up=r1/gcd;
			int down=r2/gcd;
			bw.write(up+"/"+down+"\n");
		}
		bw.close();

	}
	static int getGCD(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGCD(b,a%b);
	}

}
