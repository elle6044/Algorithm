import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[] array;

	public static void main(String[] args) throws Exception {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			answer=0;
			int K=Integer.parseInt(br.readLine());
			int N=(int)Math.pow(2, K);
			array=new int[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				array[i]=Integer.parseInt(st.nextToken());
			}
			
			recursive(0,N-1,N);
			
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();
	}
	
	static int answer;
	
	static int recursive(int left, int right, int cnt) {
		
		if(cnt==1) {
			return array[left];
		}
		
		int a=recursive(left, left+cnt/2-1, cnt/2);
		int b=recursive(left+cnt/2, right, cnt/2);
		int next=Math.max(a, b);
		answer+=Math.abs(a-b);
		return next;
	}

}
