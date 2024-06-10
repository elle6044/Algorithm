import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		char[][] map=new char[N][M];
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=input.charAt(j);
			}
		}
		
		int answer=64;
		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				int cnt1=0;
				int cnt2=0;
				char start='W';
				for(int r=0;r<8;r++) {
					for(int c=0;c<8;c++) {
						int nr=i+r;
						int nc=j+c;
						if(nr%2==nc%2) {
							if(start!=map[nr][nc]) {
								cnt1++;
							}
							else {
								cnt2++;
							}
						}
						else {
							if(start==map[nr][nc]) {
								cnt1++;
							}
							else {
								cnt2++;
							}
						}
					}
				}
				answer=Math.min(answer, Math.min(cnt1, cnt2));
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
