import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static boolean[] v=new boolean[101];

	public static void main(String[] args) throws Exception {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<3;i++) {
				int input=Integer.parseInt(st.nextToken());
				v[input]=!v[input];
			}
			
			for(int i=1;i<=100;i++) {
				if(v[i]) {
					bw.write("#"+t+" "+i+"\n");
					v[i]=false;
					break;
				}
			}
		}
		bw.close();

	}

}
