import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{

		int T=Integer.parseInt(br.readLine());
		L:for(int t=1;t<=T;t++) {
			String input=br.readLine();
			int len=input.length();
			for(int i=0;i<len/2;i++) {
				if(input.charAt(i)!=input.charAt(len-1-i)||
						input.charAt(i)!=input.charAt(len/2-1-i)||
						input.charAt(len-1-i)!=input.charAt(len/2+1+i)) {
					bw.write("#"+t+" NO\n");
                    
					continue L;
				}
			}
			
			bw.write("#"+t+" YES\n");
		}
		bw.close();
	}

}
