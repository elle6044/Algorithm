import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,K,B;
	static boolean[] v;

	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		v=new boolean[N+1];
		for(int i=0;i<B;i++) {
			int a=Integer.parseInt(br.readLine());
			v[a]=true;
		}
		
		int cnt=0;
		for(int i=1;i<=K;i++) {
			if(v[i]) {
				cnt++;
			}
		}
		int answer=cnt;
		for(int i=K+1;i<=N;i++) {
			if(v[i]) {
				cnt++;
			}
			if(v[i-K]) {
				cnt--;
			}
			answer=Math.min(answer, cnt);
		}
		bw.write(answer+"");
		bw.close();
	}

}
