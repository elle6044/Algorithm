import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static List<Integer>[] lists;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		
		lists=new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			lists[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			
			lists[s].add(e);
			lists[e].add(s);
		}
		
		v=new boolean[N+1];
		v[1]=true;
		dfs(1);
		
		bw.write(answer+"");
		bw.close();
	}
	
	static int answer=0;
	
	static void dfs(int node) {
		for(int next : lists[node]) {
			if(!v[next]) {
				answer++;
				v[next]=true;
				dfs(next);
			}
		}
	}

}
