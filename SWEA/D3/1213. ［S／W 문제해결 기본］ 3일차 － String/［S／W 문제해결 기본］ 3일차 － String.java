import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		for(int t=1;t<=10;t++) {
			int T=Integer.parseInt(br.readLine());
			
			char[] target=br.readLine().toCharArray();
			char[] input=br.readLine().toCharArray();
			
			
			int N=input.length;
			int M=target.length;
			
			int cnt=0;
			
			L:for(int i=0;i<=N-M;i++) {
				for(int j=0;j<M;j++) {
					if(target[j]!=input[i+j]) continue L;
				}
				cnt++;
			}
			bw.write("#"+t+" "+cnt+"\n");
			
		}
		bw.close();
	}

}
