import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	public static void main(String[] args) throws Exception {
		String input=br.readLine();
		N=input.length();
		
		int answer=0;
		int cnt=0;
		
		for(int i=1;i<N;i++) {
			char a=input.charAt(i-1);
			char b=input.charAt(i);
			if(a==b) {
				if(a=='(') {
					cnt++;
				}
				else {
					answer+=cnt;
				}
			}
		}
		bw.write(answer+"");
		bw.close();
	}

}
