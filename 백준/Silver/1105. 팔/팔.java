import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		String left=st.nextToken();
		String right=st.nextToken();
		
		int answer=0;
		if(left.length()==right.length()) {
			for(int i=0;i<left.length();i++) {
				if(left.charAt(i)==right.charAt(i)) {
					if(left.charAt(i)=='8') {
						answer++;
					}
				}
				else {
					break;
				}
			}
		}
		bw.write(answer+"");
		bw.close();
	}

}
