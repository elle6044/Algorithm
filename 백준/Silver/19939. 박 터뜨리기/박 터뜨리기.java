import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int answer=0;
		if(N<(K+1)*K/2) {
			answer=-1;
		}
		else {
			answer=K-1;
			int over=N-(K+1)*K/2;
			answer+=over%K==0?0:1;
		}
		bw.write(answer+"");
		bw.close();
	}

}
