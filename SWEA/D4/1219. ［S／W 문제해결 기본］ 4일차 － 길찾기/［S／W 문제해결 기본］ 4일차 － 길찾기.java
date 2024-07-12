import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static List<Integer>[] lists;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		for(int t=1;t<=10;t++) {
			st=new StringTokenizer(br.readLine());
			int T=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			
			lists=new ArrayList[100];
			v=new boolean[100];
			for(int i=0;i<100;i++) {
				lists[i]=new ArrayList();
			}
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int s=Integer.parseInt(st.nextToken());
				int e=Integer.parseInt(st.nextToken());
				lists[s].add(e);
			}
			
			int answer=0;
			Queue<Integer> q=new ArrayDeque();
			q.offer(0);
			v[0]=true;
			while(!q.isEmpty()) {
				int now=q.poll();
				if(now==99) {
					answer=1;
					break;
				}
				for(int next:lists[now]) {
					if(v[next]) continue;
					
					q.offer(next);
					v[next]=true;
				}
			}
			
			bw.write("#"+T+" "+answer+"\n");
		}
		bw.close();

	}

}
