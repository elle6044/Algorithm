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
		
		String input=br.readLine();
		int answer=0;
		
		boolean[] v=new boolean[N];
		for(int i=0;i<N;i++) {
			if(input.charAt(i)=='P') {
				for(int j=Math.max(0, i-K);j<=Math.min(N-1, i+K);j++) {
					if(input.charAt(j)=='H'&&!v[j]) {
						answer++;
						v[j]=true;
						break;
					}
				}
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
