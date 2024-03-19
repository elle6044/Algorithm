import java.io.*;
import java.util.*;
public class Solution {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		int TC=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			boolean check=false;
			int sum=0;
			Set<String> set=new HashSet<>();
			for(int i=0;i<N;i++) {
				String input=br.readLine();
				if(set.contains(input)) {
					sum+=M*2;
				}
				else {
					if(!check&&isPal(input)) {
						check=true;
						sum+=M;
					}
					else {
						StringBuilder sb=new StringBuilder(input);
						set.add(sb.reverse().toString());
					}
				}
			}
			bw.write("#"+tc+" "+sum+"\n");
		}
		bw.close();
	}

	private static boolean isPal(String input) {
		for(int i=0;i<input.length()/2;i++) {
			if(input.charAt(i)!=input.charAt(input.length()-1-i)) {
				return false;
			}
		}
		return true;
	}

}
