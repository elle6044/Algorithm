import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int K=Integer.parseInt(br.readLine());
			Stack<Integer> stack=new Stack();
			int sum=0;
			for(int i=0;i<K;i++) {
				int input=Integer.parseInt(br.readLine());
				if(input==0) {
					sum-=stack.pop();
				}
				else {
					sum+=input;
					stack.add(input);
				}
			}
			bw.write("#"+t+" "+sum+"\n");
		}
		bw.close();
	}

}
