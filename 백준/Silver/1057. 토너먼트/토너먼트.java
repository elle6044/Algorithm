import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int a=Integer.parseInt(st.nextToken())-1;
		int b=Integer.parseInt(st.nextToken())-1;
		
		int answer=0;
		while(a!=b) {
			a/=2;
			b/=2;
			answer++;
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
