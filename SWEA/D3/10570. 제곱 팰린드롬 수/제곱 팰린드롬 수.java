import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static boolean[] array=new boolean[1001];
	
	public static void main(String[] args) throws Exception {
		for(int i=1;i<=Math.sqrt(1000);i++) {
			if(isTrue(i)) {
				if(isTrue(i*i)) {
					array[i*i]=true;
				}
			}
		}
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			int cnt=0;
			for(int i=a;i<=b;i++) {
				if(array[i]) cnt++;
			}
			bw.write("#"+t+" "+cnt+"\n");
		}
		bw.close();

	}
	
	static boolean isTrue(int a) {
		boolean check=true;
		String word=Integer.toString(a);
		for(int i=0;i<word.length()/2;i++) {
			if(word.charAt(i)!=word.charAt(word.length()-1-i)) {
				check=false;
				break;
			}
		}
		
		return check;
	}

}
