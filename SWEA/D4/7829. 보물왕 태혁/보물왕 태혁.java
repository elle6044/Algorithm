import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			int[] array=new int[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				array[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(array);
			
			int answer=0;
			if(N==1) {
				answer=array[0]*array[0];
			}
			else {
				answer=array[0]*array[N-1];
			}
			
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();
	}
	
	static int getGCD(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGCD(b,a%b);
	}

}
