import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		int T=Integer.parseInt(br.readLine());
		boolean[] check1,check2;
		for(int t=1;t<=T;t++) {
			check1=new boolean[8];
			check2=new boolean[8];
			String answer="yes";
			int cnt=0;
			L:for(int i=0;i<8;i++) {
				String input=br.readLine();
				if(answer.equals("yes")) {
					for(int j=0;j<8;j++) {
						if(input.charAt(j)=='O') {
							if(check1[i]||check2[j]) {
								answer="no";
							}
							cnt++;
							check1[i]=true;
							check2[j]=true;
						}
					}
				}
			}
			if(cnt!=8) answer="no";
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();

	}

}
