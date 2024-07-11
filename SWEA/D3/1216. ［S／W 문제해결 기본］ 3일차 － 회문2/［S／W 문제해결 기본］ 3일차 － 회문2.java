import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static char[][] array;
	public static void main(String[] args) throws Exception {
		for(int t=1;t<=10;t++) {
			int T=Integer.parseInt(br.readLine());
			array=new char[100][100];
			for(int i=0;i<100;i++) {
				String input=br.readLine();
				for(int j=0;j<100;j++) {
					array[i][j]=input.charAt(j);
				}
			}
			
			int answer=1;
			L:for(int i=100;i>=1;i--) {
				for(int r=0;r<100;r++) {
					for(int c=0;c<=100-i;c++) {
						boolean check1=true;
						boolean check2=true;
						for(int x=0;x<i/2;x++) {
							if(array[r][c+x]!=array[r][c+i-1-x]) {
								check1=false;
							}
							if(array[c+x][r]!=array[c+i-1-x][r]) {
								check2=false;
							}
						}
						if(check1||check2) {
							answer=i;
							break L;
						}
					}
					
				}
			}
			bw.write("#"+T+" "+answer+"\n");
		}
		bw.close();

	}

}
