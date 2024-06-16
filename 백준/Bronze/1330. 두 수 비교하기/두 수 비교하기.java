import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		String answer="";
		if(A==B) {
			answer="==";
		}
		else if(A>B) {
			answer=">";
		}
		else {
			answer="<";
		}
		bw.write(answer);
		bw.close();

	}

}
