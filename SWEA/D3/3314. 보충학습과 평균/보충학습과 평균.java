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
			int sum=0;
			for(int i=0;i<5;i++) {
				int input=Integer.parseInt(st.nextToken());
				sum+=input<40?40:input;
			}
			bw.write("#"+t+" "+sum/5+"\n");
		}
		bw.close();
	}

}
