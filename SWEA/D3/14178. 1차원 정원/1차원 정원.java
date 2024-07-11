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
			int N=Integer.parseInt(st.nextToken());
			int D=Integer.parseInt(st.nextToken());
			int a=N/(D*2+1);
			int b=N%(D*2+1);
			
			int answer=b==0?a:a+1;
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();
	}

}
