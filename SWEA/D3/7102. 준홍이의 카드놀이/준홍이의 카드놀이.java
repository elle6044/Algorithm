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
			
			int max=0;
			int[] array=new int[N+M+1];
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					array[i+j]++;
					max=Math.max(max, array[i+j]);
				}
			}
			
			bw.write("#"+t);
			for(int i=2;i<=N+M;i++) {
				if(array[i]==max) {
					bw.write(" "+i);
				}
			}
			bw.write("\n");
			
		}
		bw.close();
	}

}
