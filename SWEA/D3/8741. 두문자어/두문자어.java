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
			bw.write("#"+t+" ");
			while(st.hasMoreTokens()) {
				String word=st.nextToken();
				bw.write(Character.toUpperCase(word.charAt(0)));
			}
			bw.write("\n");
		}
		bw.close();
	}

}
