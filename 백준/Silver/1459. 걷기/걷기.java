import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		long r=Long.parseLong(st.nextToken());
		long c=Long.parseLong(st.nextToken());
		long w=Long.parseLong(st.nextToken());
		long s=Long.parseLong(st.nextToken());
		
		long answer=0;
		
		if(2*w<s) {
			answer=(r+c)*w;
		}
		else {
			if(w>s) {
				answer=Math.min(r, c)*s+Math.abs(r-c)*w;
				if(r%2==c%2) {
					answer=Math.min(answer, Math.max(r, c)*s);
				}
				else {
					answer=Math.min(answer, (Math.max(r, c)-1)*s+w);
				}
			}
			else {
				answer=Math.min(r, c)*s+Math.abs(r-c)*w;
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
