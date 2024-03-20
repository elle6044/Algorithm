import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int TC=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			int N=Integer.parseInt(br.readLine());
			bw.write("#"+tc+" "+N*N+"\n");
		}
		bw.close();
	}

}
