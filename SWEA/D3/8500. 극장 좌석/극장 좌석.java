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
			int max=0;
			int sum=0;
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int input=Integer.parseInt(st.nextToken());
				sum+=input;
				max=Math.max(max, input);
			}
			sum+=max+N;
			bw.write("#"+t+" "+sum+"\n");
		}
		bw.close();
	}

}
