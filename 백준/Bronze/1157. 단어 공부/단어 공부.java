import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		String input=br.readLine();
		input=input.toUpperCase();
		
		Map<Character,Integer> map=new HashMap();
		
		for(int i=0;i<input.length();i++) {
			char word=input.charAt(i);
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		int mcnt=0;
		char mword=' ';
		for(char key:map.keySet()) {
			int cnt=map.get(key);
			if(mcnt<cnt) {
				mcnt=cnt;
				mword=key;
			}
			else if(mcnt==cnt) {
				mword='?';
			}
		}
		
		bw.write(mword);
		bw.close();

	}

}
