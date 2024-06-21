import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int c=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		
		int gcd=getGCD(b,d);
		int lcm=b*d/gcd;
		
		int up=a*(lcm/b)+c*(lcm/d);
		int down=lcm;
		
		int gcd2=getGCD(up,down);
		bw.write(up/gcd2+" "+down/gcd2);
		bw.close();
	}

	static int getGCD(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGCD(b,a%b);
	}
}
