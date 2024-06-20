import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		String input=br.readLine();
		
		int r=0;
		int c=0;
		int d=0;
		
		int minr=0;
		int minc=0;
		int maxr=0;
		int maxc=0;
		
		for(int i=0;i<N;i++) {
			char word=input.charAt(i);
			if(word=='F') {
				r+=dr[d];
				c+=dc[d];
				minr=Math.min(minr, r);
				minc=Math.min(minc, c);
				maxr=Math.max(maxr, r);
				maxc=Math.max(maxc, c);
			}
			else if(word=='L') {
				d+=3;
				d%=4;
			}
			else if(word=='R') {
				d++;
				d%=4;
			}
		}
		
		int h=maxr-minr+1;
		int w=maxc-minc+1;
		
		int sr=h-1-maxr;
		int sc=w-1-maxc;
		
		char[][] map=new char[h][w];
		for(int i=0;i<h;i++) {
			Arrays.fill(map[i], '#');
		}
		map[sr][sc]='.';
		d=0;
		for(int i=0;i<N;i++) {
			char word=input.charAt(i);
			if(word=='F') {
				sr+=dr[d];
				sc+=dc[d];
				map[sr][sc]='.';
			}
			else if(word=='L') {
				d+=3;
				d%=4;
			}
			else if(word=='R') {
				d++;
				d%=4;
			}
		}
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				bw.write(map[i][j]);
			}
			bw.write("\n");
		}
		bw.close();
	}
	
	static int[] dr= {1,0,-1,0};
	static int[] dc= {0,-1,0,1};

}
