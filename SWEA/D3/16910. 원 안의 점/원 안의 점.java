import java.io.*;
import java.util.*;
public class Solution {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			int cnt=0;
			for(int i=-N;i<=N;i++) {
				for(int j=-N;j<=N;j++) {
					if(N*N>=i*i+j*j) {
						cnt++;
					}
				}
			}
			bw.write("#"+t+" "+cnt+"\n");
		}
		bw.close();

	}

}
