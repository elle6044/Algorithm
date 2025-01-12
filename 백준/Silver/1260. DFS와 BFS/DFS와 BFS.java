import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,M,V;
	static Set[] sets;
	
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		V=Integer.parseInt(st.nextToken())-1;
		
		sets=new TreeSet[N];
		for(int i=0;i<N;i++) {
			TreeSet<Integer> set=new TreeSet();
			sets[i]=set;
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
		bw.write("\n");
		
		v=new boolean[N];
		bfs(V);
		
		bw.close();
	}
	
	static void dfs(int idx) throws Exception{
		bw.write((idx+1)+" ");
		
		Set<Integer> set=sets[idx];
		for(Integer next : set) {
			if(!v[next]) {
				v[next]=true;
				dfs(next);
			}
		}
	}
	
	static void bfs(int idx) throws Exception {
		Queue<Integer> q=new ArrayDeque();
		q.offer(idx);
		v[idx]=true;
		while(!q.isEmpty()) {
			int now=q.poll();
			bw.write((now+1)+" ");
			Set<Integer> set=sets[now];
			for(Integer next : set) {
				if(!v[next]) {
					q.offer(next);
					v[next]=true;
				}
			}
		}
	}

}
