import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		String input=br.readLine();
		Stack<Character> s1=new Stack();
		Stack<Character> s2=new Stack();
		for(int i=0;i<input.length();i++) {
			s1.add(input.charAt(i));
		}
		
		int N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String com=br.readLine();
			char a=com.charAt(0);
			
			if(a=='L') {
				if(!s1.isEmpty()) {
					s2.add(s1.pop());
				}
			}
			else if(a=='D') {
				if(!s2.isEmpty()) {
					s1.add(s2.pop());
				}
			}
			else if(a=='B') {
				if(!s1.isEmpty()) {
					s1.pop();
				}
			}
			else if(a=='P') {
				s1.add(com.charAt(2));
			}
		}
		
		while(!s1.isEmpty()) {
			s2.add(s1.pop());
		}
		while(!s2.isEmpty()) {
			bw.write(s2.pop());
		}
		bw.close();
		

	}
}
