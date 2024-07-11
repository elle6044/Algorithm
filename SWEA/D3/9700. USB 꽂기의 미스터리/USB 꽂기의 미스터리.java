import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			double p=Double.parseDouble(st.nextToken());
			double q=Double.parseDouble(st.nextToken());
			
			double s1=(1-p)*q;
			double s2=p*(1-q)*q;
			
			String answer=s1<s2?"YES":"NO";
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();
	}

}
