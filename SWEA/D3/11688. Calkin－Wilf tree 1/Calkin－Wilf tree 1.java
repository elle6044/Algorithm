import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String input=br.readLine();
			int a=1;
			int b=1;
			
			for(int i=0;i<input.length();i++) {
				char word=input.charAt(i);
				if(word=='L') {
					b+=a;
				}
				else {
					a+=b;
				}
			}
			
			bw.write("#"+t+" "+a+" "+b+"\n");
		}
		bw.close();
	}

}
