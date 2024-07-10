import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String input=br.readLine();
			int num=Character.getNumericValue(input.charAt(input.length()-1));
			String answer=num%2==1?"Odd":"Even";
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();
	}

}
