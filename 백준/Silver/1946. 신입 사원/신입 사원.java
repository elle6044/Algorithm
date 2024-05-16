import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			int[] score1=new int[N];
			int[] score2=new int[N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				score1[Integer.parseInt(st.nextToken())-1]=i;
				score2[i]=Integer.parseInt(st.nextToken())-1;
			}
			
			int cnt=1;
			int cut=score2[score1[0]];
			
			for(int i=1;i<N;i++) {
				int score=score2[score1[i]];
				if(score<cut) {
					cnt++;
					cut=score;
				}
			}
			bw.write(cnt+"\n");
		}
		bw.close();

	}

}
