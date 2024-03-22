import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			String A=st.nextToken();
			String B=st.nextToken();
			String answer="1";
			if(A.equals(B)) answer=A;
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();
	}
}