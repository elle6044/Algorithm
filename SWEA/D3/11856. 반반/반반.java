import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] array;

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			array=new int[26];
			String input=br.readLine();
			int cnt=0;
			for(int i=0;i<4;i++) {
				int a=input.charAt(i)-65;
				array[a]++;
				if(array[a]==2) cnt++;
			}
			String answer="No";
			if(cnt==2) {
				answer="Yes";
			}
			
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();

	}

}
