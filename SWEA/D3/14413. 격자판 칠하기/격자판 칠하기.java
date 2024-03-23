import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static String answer;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		char[][] base=new char[50][50];
		base=new char[50][50];
		for(int i=0;i<50;i++) {
			for(int j=0;j<50;j++) {
				if((i%2==0&&j%2==0)||(i%2==1&&j%2==1)) {
					base[i][j]='#';
				}
				else {
					base[i][j]='.';
				}
			}
		}
		
		char[][] map;

		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			map=new char[N][M];
			answer="impossible";
			int cnt=0;
			for(int i=0;i<N;i++) {
				String input=br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j]=input.charAt(j);
					if(map[i][j]!='?') cnt++;
				}
			}
			
			int a=0;
			int b=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]!='?') {
						if(map[i][j]==base[i][j]) {
							a++;
						}
						else {
							b++;
						}
					}
				}
			}
			if(a==cnt||b==cnt) answer="possible";
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();

	}

}
