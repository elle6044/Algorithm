import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int deg=Integer.parseInt(br.readLine());
			deg*=2;
			int h=deg/60;
			int m=deg%60;
			bw.write("#"+t+" "+h+" "+m+"\n");
		}
		bw.close();
	}

}
