import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static Map<Character,Character> map=new HashMap();

	public static void main(String[] args) throws Exception{
		map.put('b', 'd');
		map.put('d', 'b');
		map.put('q', 'p');
		map.put('p', 'q');
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String input=br.readLine();
			bw.write("#"+t+" ");
			for(int i=input.length()-1;i>=0;i--) {
				bw.write(map.get(input.charAt(i)));
			}
			bw.write("\n");
		}
		bw.close();
	}

}
