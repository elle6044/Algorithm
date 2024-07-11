import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String input=br.readLine();
			Set<Character> set=new HashSet();
			for(int i=0;i<input.length();i++) {
				char word=input.charAt(i);
				if(set.contains(word)) set.remove(word);
				else set.add(word);
			}
			
			bw.write("#"+t+" "+set.size()+"\n");
		}
		bw.close();
	}

}
