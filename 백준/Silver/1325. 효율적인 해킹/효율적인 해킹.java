import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static List<Integer>[] lists;
	static boolean[] v;
	static int[] cnt;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		lists=new ArrayList[N];
		for(int i=0;i<N;i++) {
			lists[i]=new ArrayList();
		}
		
		cnt=new int[N];
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			lists[a].add(b);
		}
		
		for(int i=0;i<N;i++) {
			v=new boolean[N];
			bfs(i);
		}
		
		for(int i=0;i<N;i++) {
			max=Math.max(max, cnt[i]);
		}

		
		for(int i=0;i<N;i++) {
			if(cnt[i]==max) {
				bw.write((i+1)+" ");
			}
		}
		bw.close();
	}

	static int max=0;
	
	static void bfs(int idx) {
		Queue<Integer> q=new ArrayDeque();
		q.offer(idx);
		v[idx]=true;
		while(!q.isEmpty()) {
			int pre=q.poll();
			for(int next:lists[pre]) {
				if(!v[next]) {
					q.offer(next);
                    v[next]=true;
					cnt[next]++;
				}
			}
		}
	}
}
