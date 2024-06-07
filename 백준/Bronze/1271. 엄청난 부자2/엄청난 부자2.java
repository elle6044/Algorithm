import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		BigInteger a=new BigInteger(st.nextToken());
		BigInteger b=new BigInteger(st.nextToken());
		
		bw.write(a.divide(b).toString()+"\n"+a.mod(b).toString());
		bw.close();
	}

}
