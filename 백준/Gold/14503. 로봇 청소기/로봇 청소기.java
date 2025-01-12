import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[][] map;
	
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
		
	static class Robot{
		int r,c,d,score;
		public Robot(int r, int c, int d, int score) {
			this.r=r;
			this.c=c;
			this.d=d;
			this.score=score;
		}
	}
	
	static Robot robot;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int sr=Integer.parseInt(st.nextToken());
		int sc=Integer.parseInt(st.nextToken());
		int sd=Integer.parseInt(st.nextToken());
		robot=new Robot(sr, sc, sd, 0);
		
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			clear();

			int dir=checkDir();
			if(dir==-1) {
				if(checkBack()) {
					back();
				}
				else {
					break;
				}
			}
			else {
				changeDir(dir);
				move();
			}
		}
		
		bw.write(robot.score+"");
		bw.close();
	}
	
	static void move() {
		robot.r+=dr[robot.d];
		robot.c+=dc[robot.d];
	}
	
	static void changeDir(int dir) {
		robot.d=dir;
	}
	
	static void back() {
		robot.r+=dr[(robot.d+2)%4];
		robot.c+=dc[(robot.d+2)%4];
	}
	
	static boolean checkBack() {
		int nr=robot.r+dr[(robot.d+2)%4];
		int nc=robot.c+dc[(robot.d+2)%4];
		if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]!=1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	static int checkDir() {
		int dir=-1;
		for(int d=3;d>=0;d--) {
			int nd=(robot.d+d)%4;
			int nr=robot.r+dr[nd];
			int nc=robot.c+dc[nd];
			if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==0) {
				dir=nd;
				break;
			}
		}
		return dir;
	}
	
	static void clear() {
		if(map[robot.r][robot.c]==0) {
			robot.score++;
			map[robot.r][robot.c]=-1;
		}
	}
	
}
