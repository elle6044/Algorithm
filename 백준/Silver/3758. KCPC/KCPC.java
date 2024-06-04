import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			int ID=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			int[][] score=new int[N+1][K+1];
			int[] cnt=new int[N+1];
			int[] time=new int[N+1];
			
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int id=Integer.parseInt(st.nextToken());
				int j=Integer.parseInt(st.nextToken());
				int s=Integer.parseInt(st.nextToken());
				
				score[id][j]=Math.max(score[id][j], s);
				cnt[id]++;
				time[id]=i;
			}
			
			PriorityQueue<Point> pq=new PriorityQueue();
			for(int i=1;i<=N;i++) {
				int s=0;
				for(int j=1;j<=K;j++) {
					s+=score[i][j];
				}
				pq.offer(new Point(i,s, cnt[i], time[i]));
			}
			
			int rank=1;
			while(!pq.isEmpty()) {
				Point p=pq.poll();
				if(p.t==ID) {
					bw.write(rank+"\n");
					break;
				}
				rank++;
			}
		}
		bw.close();
	}
	
	static class Point implements Comparable<Point>{
		int t, score, cnt, time;
		public Point(int t, int score, int cnt, int time) {
			this.t=t;
			this.score=score;
			this.cnt=cnt;
			this.time=time;
		}
		@Override
		public int compareTo(Point o) {
			return o.score==this.score?this.cnt==o.cnt?Integer.compare(this.time, o.time):Integer.compare(this.cnt, o.cnt):Integer.compare(o.score, this.score);
		}
	}
}
