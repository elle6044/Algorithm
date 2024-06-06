import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M,V;
	static Set<Integer>[] sets;
	
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		V=Integer.parseInt(st.nextToken())-1;
		sets=new TreeSet[N];
		
		for(int i=0;i<N;i++) {
			sets[i]=new TreeSet();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			sets[s].add(e);
			sets[e].add(s);
		}

		v=new boolean[N];
		v[V]=true;
		dfs(V);
		sb.append("\n");
		
		v=new boolean[N];
		v[V]=true;
		bfs(V);
		
		bw.write(sb.toString());
		bw.close();
		
	}
	
	static StringBuilder sb=new StringBuilder();
	static void bfs(int idx) {
		Queue<Integer> q=new ArrayDeque();
		q.offer(idx);
		while(!q.isEmpty()) {
			int a=q.poll();
			sb.append((a+1)).append(" ");
			Set<Integer> set=sets[a];
			for(int b:set) {
				if(!v[b]) {
					q.offer(b);
					v[b]=true;
				}
			}
		}
	}
	static void dfs(int idx) throws Exception {
		sb.append((idx+1)).append(" ");
		Set<Integer> set=sets[idx];
		for(int a:set) {
			if(v[a]) continue;
			v[a]=true;
			dfs(a);
		}
	}
}
