import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String input=br.readLine();
			int start=97;
			for(int i=0;i<input.length();i++) {
				if(start==input.charAt(i)) {
					start++;
				}
				else {
					break;
				}
			}
			bw.write("#"+t+" "+(start-97)+"\n");
		}
		bw.close();
	}

}
