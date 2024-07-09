import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			String a=br.readLine();
			String b=br.readLine();
			int cnt=0;
			for(int i=0;i<N;i++) {
				if(a.charAt(i)==b.charAt(i)) cnt++;
			}
			bw.write("#"+t+" "+cnt+"\n");
		}
		bw.close();
	}

}
