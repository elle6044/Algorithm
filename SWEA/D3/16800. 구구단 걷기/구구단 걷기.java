import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int TC=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			long N=Long.parseLong(br.readLine());
			int start=(int) Math.sqrt(N);
			for(long i=start;i>=1;i--) {
				if(N%i==0) {
					bw.write("#"+tc+" "+(i+N/i-2)+"\n");
					break;
				}
			}
		}
		bw.close();
	}
}
