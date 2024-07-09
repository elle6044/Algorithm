import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		for(int t=1;t<=10;t++) {
			int N=Integer.parseInt(br.readLine());
			int[][] map=new int[N][N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt=0;
			for(int i=0;i<N;i++) {
				boolean check=false;
				for(int j=0;j<N;j++) {
					int input=map[j][i];
					if(input==1) {
						check=true;
					}
					if(input==2) {
						if(check) {
							cnt++;
							check=false;
						}
					}
				}
			}
			bw.write("#"+t+" "+cnt+"\n");
		}
		bw.close();
	}

}
