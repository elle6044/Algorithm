import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		char[][] map=new char[N][N];
		
		int hr=0;
		int hc=0;
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<N;j++) {
				char word=input.charAt(j);
				map[i][j]=word;
				if(hr==0&&word=='*') {
					hr=i+1;
					hc=j;
				}
			}
		}
		
		int[] cnt= {0,0,0,0,0};
		
		for(int d=0;d<3;d++) {
			int nr=hr+dr[d];
			int nc=hc+dc[d];
			while(nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc]=='*') {
				cnt[d]++;
				nr+=dr[d];
				nc+=dc[d];
			}
		}
		
		for(int i=3;i<5;i++) {
			int nr=hr+cnt[2]+1;
			int nc=hc+(i==3?-1:1);
			while(nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc]=='*') {
				cnt[i]++;
				nr+=dr[2];
				nc+=dc[2];
			}
		}
		
		bw.write((hr+1)+" "+(hc+1)+"\n");
		for(int i=0;i<5;i++) {
			bw.write(cnt[i]+" ");
		}
		bw.close();

	}
	
	static int[] dr= {0,0,1};
	static int[] dc= {-1,1,0};

}
