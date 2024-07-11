import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] month= {0,31,29,31,30,31,30,31,31,30,31,30,31};

	public static void main(String[] args) throws Exception {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			int m=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			
			int day=d-1;
			for(int i=1;i<m;i++) {
				day+=month[i];
			}
			
			int answer=(4+day%7)%7;
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();
	}

}
