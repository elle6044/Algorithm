import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static boolean[] array;

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			array=new boolean[N+1];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<K;i++) {
				int num=Integer.parseInt(st.nextToken());
				array[num]=true;
			}
			
			bw.write("#"+t);
			for(int i=1;i<=N;i++) {
				if(!array[i]) {
					bw.write(" "+i);
				}
			}
			bw.write("\n");
		}
		bw.close();
	}

}
