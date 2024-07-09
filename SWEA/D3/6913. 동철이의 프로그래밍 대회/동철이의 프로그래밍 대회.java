import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			int answer=0;
			int max=0;
			for(int i=0;i<N;i++) {
				int cnt=0;
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					int input=Integer.parseInt(st.nextToken());
					cnt+=input;
				}
				
				if(max<cnt) {
					max=cnt;
					answer=1;
				}
				else if(max==cnt) {
					answer++;
				}
			}
			bw.write("#"+t+" "+answer+" "+max+"\n");
		}
		bw.close();
	}

}
