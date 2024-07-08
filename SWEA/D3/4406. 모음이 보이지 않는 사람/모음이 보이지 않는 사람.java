import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static Set<Character> set=new HashSet();
	
	public static void main(String[] args) throws Exception{
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String input=br.readLine();
			bw.write("#"+t+" ");
			for(int i=0;i<input.length();i++) {
				char a=input.charAt(i);
				if(!set.contains(a)) {
					bw.write(a);
				}
			}
			bw.write("\n");
		}
		bw.close();

	}

}
