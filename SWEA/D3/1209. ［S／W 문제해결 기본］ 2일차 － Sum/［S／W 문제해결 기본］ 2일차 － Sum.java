import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[][] map=new int[100][100];

	public static void main(String[] args) throws Exception {
		for(int t=1;t<=10;t++) {
			int T=Integer.parseInt(br.readLine());
			for(int i=0;i<100;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int max=0;
			
			int sum1=0;
			int sum2=0;
			for(int i=0;i<100;i++) {
				sum1+=map[i][i];
				sum2+=map[99-i][i];
			}
			
			max=Math.max(sum1, sum2);
			
			for(int i=0;i<100;i++) {
				int s1=0;
				int s2=0;
				for(int j=0;j<100;j++) {
					s1+=map[i][j];
					s2+=map[j][i];
				}
				max=Math.max(max, Math.max(s1, s2));
			}
			bw.write("#"+t+" "+max+"\n");
		}
		bw.close();
	}

}
