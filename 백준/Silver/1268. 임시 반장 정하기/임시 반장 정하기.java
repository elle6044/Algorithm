import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][5];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int max=0;
		int answer=0;
		boolean[][] v=new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<5;j++) {
				int c=map[i][j];
				for(int i2=0;i2<N;i2++) {
					if(c==map[i2][j]) {
						v[i][i2]=true;
					}
				}
			}
			int cnt=0;
			for(int j=0;j<N;j++) {
				if(v[i][j]) cnt++;
			}
			
			if(cnt>max) {
				max=cnt;
				answer=i;
			}
		}
		
		bw.write((answer+1)+"");
		bw.close();

	}

}
