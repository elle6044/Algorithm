import java.io.*;
import java.util.*;
public class Solution {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int TC=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			int N=Integer.parseInt(br.readLine());
			String input=br.readLine();
			if(N%2==1) {
				bw.write("#"+tc+" No\n");
			}
			else {
				if(input.substring(0,N/2).equals(input.substring(N/2))) {
					bw.write("#"+tc+" Yes\n");
				}
				else {
					bw.write("#"+tc+" No\n");
				}
			}
		}
		bw.close();
	}
}
