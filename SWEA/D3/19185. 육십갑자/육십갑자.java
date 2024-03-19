import java.io.*;
import java.util.*;
public class Solution {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{

		int TC=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			String[] s=new String[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				s[i]=st.nextToken();
			}
			
			String[] t=new String[M];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				t[i]=st.nextToken();
			}
			
			int Q=Integer.parseInt(br.readLine());
			bw.write("#"+tc+" ");
			for(int q=0;q<Q;q++) {
				int year=Integer.parseInt(br.readLine())-1;
				bw.write(s[year%N]+t[year%M]+" ");
			}
			bw.write("\n");
		}
		bw.close();
	}

}
