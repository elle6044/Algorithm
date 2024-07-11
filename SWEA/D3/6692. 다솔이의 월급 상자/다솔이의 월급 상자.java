import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			double answer=0;
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				double a=Double.parseDouble(st.nextToken());
				double b=Double.parseDouble(st.nextToken());
				answer+=a*b;
			}
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();
	}

}
