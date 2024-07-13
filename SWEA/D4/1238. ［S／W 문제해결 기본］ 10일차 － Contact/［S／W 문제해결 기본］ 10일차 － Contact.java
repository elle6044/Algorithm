import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static List<Integer>[] lists;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		for(int t=1;t<=10;t++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int S=Integer.parseInt(st.nextToken());
			
			lists=new ArrayList[101];
			v=new boolean[101];
			for(int i=1;i<=100;i++) {
				lists[i]=new ArrayList();
			}
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N/2;i++) {
				int s=Integer.parseInt(st.nextToken());
				int e=Integer.parseInt(st.nextToken());
				lists[s].add(e);
			}
			
			Queue<Integer> q=new ArrayDeque();
			q.offer(S);
			v[S]=true;
			
			int answer=S;
			while(!q.isEmpty()) {
				int size=q.size();
				int max=0;
				for(int s=0;s<size;s++) {
					int num=q.poll();
					max=Math.max(max, num);
					for(int next:lists[num]) {
						if(v[next]) continue;
						
						q.offer(next);
						v[next]=true;
						
					}
				}
				answer=max;
			}
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();

	}

}
