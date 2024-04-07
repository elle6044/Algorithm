import java.io.*;
import java.util.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M,x,y,K;
	static int[][] map;
	
	static int[] dice=new int[7];
	static int bottom=6;
	static int front=5;
	static int right=3;
	
	static int[] dr= {0,0,0,-1,1};
	static int[] dc= {0,1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			int k=Integer.parseInt(st.nextToken());
			int nr=x+dr[k];
			int nc=y+dc[k];
			if(nr<0||nr>=N||nc<0||nc>=M) continue;
			
			int temp=bottom;
			switch(k) {
			case 1:
				bottom=right;
				right=7-temp;
				break;
			case 2:
				bottom=7-right;
				right=temp;
				break;
			case 3:
				bottom=7-front;
				front=temp;
				break;
			case 4:
				bottom=front;
				front=7-temp;
				break;
			}
			if(map[nr][nc]==0) {
				map[nr][nc]=dice[bottom];
			}
			else {
				dice[bottom]=map[nr][nc];
				map[nr][nc]=0;
			}
			x=nr;
			y=nc;
			System.out.println(dice[7-bottom]);
		}
		
		
		
		

	}

}
