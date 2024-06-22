import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		BigInteger answer=new BigInteger("1");
		for(int i=0;i<M;i++) {
			answer=answer.multiply(new BigInteger(Integer.toString(N-i)));
			answer=answer.divide(new BigInteger(Integer.toString(i+1)));
		}
		
		bw.write(answer.toString());
		bw.close();

	}

}
