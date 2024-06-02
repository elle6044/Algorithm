import java.io.*;
import java.util.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			int answer=1;
			for(int i=0;i<b;i++) {
				answer=(answer*a%10)==0?10:(answer*a%10);
			}
			bw.write(answer+"\n");
		}
		bw.close();

	}

}
