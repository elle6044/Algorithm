import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String input=br.readLine();
			int cnt=0;
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='x') cnt++;
			}
			String answer=cnt>=8?"NO":"YES";
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();
	}

}
