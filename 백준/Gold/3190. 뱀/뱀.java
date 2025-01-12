import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,K,L;
	static int[][] map;
	static boolean[][] smap;
	
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	
	static class Snake{
		int d;
		ArrayDeque<Point> body=new ArrayDeque<>();
		public Snake(int d, ArrayDeque<Point> body){
			this.d=d;
			this.body=body;
		}
	}
	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
	
	static int time=0;
	static Snake snake;
	
	static Map<Integer, String> commands=new HashMap();

	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		
		map=new int[N][N];
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			map[r][c]=1;
		}
		
		smap=new boolean[N][N];
		smap[0][0]=true;
		
		ArrayDeque<Point> body=new ArrayDeque<>();
		body.add(new Point(0,0));
		snake=new Snake(1, body);
		
		L=Integer.parseInt(br.readLine());
		for(int i=0;i<L;i++) {
			st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			String command=st.nextToken();
			
			commands.put(t, command);
		}
		
		
		while(true) {
			time++;
			if(checkNext()) {
				moveHead();
				if(checkApple()) {
					eatApple();
				}
				else {
					moveTail();
				}
			}
			else {
				break;
			}
			
			doCommand();
			
			
		}
		
		bw.write(time+"");
		bw.close();
	}
	
	static void doCommand() {
		if(commands.containsKey(time)) {
			String c=commands.get(time);
			
			if(c.equals("L")) {
				snake.d=(snake.d+3)%4;
			}
			if(c.equals("D")) {
				snake.d=(snake.d+1)%4;
			}
		}
	}
	
	static void moveTail() {
		Point tail=snake.body.pollLast();
		smap[tail.r][tail.c]=false;
	}
	
	static void eatApple() {
		Point head=snake.body.peekFirst();
		map[head.r][head.c]=0;
	}
	
	static boolean checkApple() {
		Point head=snake.body.peekFirst();
		if(map[head.r][head.c]==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static void moveHead() {
		Point head=snake.body.peekFirst();
		Point nhead=new Point(head.r+dr[snake.d],head.c+dc[snake.d]);
		
		snake.body.addFirst(nhead);
		smap[nhead.r][nhead.c]=true;
	}
	
	static boolean checkNext() {
		Point head=snake.body.peekFirst();
		int nr=head.r+dr[snake.d];
		int nc=head.c+dc[snake.d];
		if(nr>=0&&nr<N&&nc>=0&&nc<N&&!smap[nr][nc]) {
			return true;
		}
		else {
			return false;
		}
	}

}
