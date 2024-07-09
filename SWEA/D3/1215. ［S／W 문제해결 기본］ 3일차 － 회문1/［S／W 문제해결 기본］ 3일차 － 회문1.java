import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	static char[][] map;
	public static void main(String[] args) throws Exception{
		for(int t=1;t<=10;t++) {
			int N=Integer.parseInt(br.readLine());
			map=new char[8][8];
			for(int i=0;i<8;i++) {
				String input=br.readLine();
				for(int j=0;j<8;j++) {
					map[i][j]=input.charAt(j);
				}
			}
			
			int cnt=0;
			for(int i=0;i<8;i++) {
				for(int j=0;j<=8-N;j++) {
					boolean check1=true;
					boolean check2=true;
					for(int k=0;k<N/2;k++) {
						if(map[i][j+k]!=map[i][j+N-1-k]) {
							check1=false;
						}
						if(map[j+k][i]!=map[j+N-1-k][i]) {
							check2=false;
						}
					}
					if(check1) cnt++;
					if(check2) cnt++;
				}
			}
			bw.write("#"+t+" "+cnt+"\n");
		}
		bw.close();
	}

}
