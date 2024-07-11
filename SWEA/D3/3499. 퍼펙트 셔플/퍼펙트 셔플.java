import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			String[] array=new String[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				array[i]=st.nextToken();
			}
			
			int a=N/2;
			bw.write("#"+t);
			
			if(N%2==1) {
				for(int i=0;i<a;i++) {
					bw.write(" "+array[i]+" "+array[i+a+1]);
				}
				bw.write(" "+array[a]);
			}
			else {
				for(int i=0;i<a;i++) {
					bw.write(" "+array[i]+" "+array[i+a]);
				}
			}
			bw.write("\n");
		}
		bw.close();
	}

}
