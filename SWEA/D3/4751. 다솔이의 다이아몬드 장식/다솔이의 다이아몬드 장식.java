import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String input=br.readLine();
			int N=input.length();
			
			for(int i=0;i<N;i++) {
				bw.write("..#.");
			}
			bw.write(".\n");
			
			for(int i=0;i<N*2;i++) {
				bw.write(".#");
			}
			bw.write(".\n");
			
			for(int i=0;i<N;i++) {
				bw.write("#."+input.charAt(i)+".");
			}
			bw.write("#\n");
			
			for(int i=0;i<N*2;i++) {
				bw.write(".#");
			}
			bw.write(".\n");
			
			for(int i=0;i<N;i++) {
				bw.write("..#.");
			}
			bw.write(".\n");
		}
		bw.close();
	}

}
