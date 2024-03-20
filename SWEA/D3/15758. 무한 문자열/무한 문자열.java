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
			String S=st.nextToken();
			String T=st.nextToken();
			String answer="yes";
			for(int i=0;i<S.length()*T.length();i++) {
				if(S.charAt(i%S.length())!=T.charAt(i%T.length())) {
					answer="no";
					break;
				}
			}
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.close();

	}

}
