import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,M,T;
	static List<Edge> edgeList=new ArrayList<>();
	static int[] parent, rank;
	
	static class Edge implements Comparable<Edge>{
		int s,e,w;
		public Edge(int s, int e, int w) {
			this.s=s;
			this.e=e;
			this.w=w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(s, e, w));
		}
		
		Collections.sort(edgeList);
		
		parent=new int[N];
		rank=new int[N];
		for(int i=0;i<N;i++) {
			parent[i]=i;
			rank[i]=0;
		}
		
		long answer=0;
		int cnt=0;
		
		for(Edge edge : edgeList) {
			int rootA=find(edge.s);
			int rootB=find(edge.e);
			if(rootA!=rootB) {
				answer+=edge.w+T*cnt;
				cnt++;
				union(rootA, rootB);
			}
			
			if(cnt==N-1) break;
		}
		
		bw.write(answer+"");
		bw.close();
	}
	
	static void union(int a, int b) {
		int rootA=find(a);
		int rootB=find(b);
		
		if(rootA!=rootB) {
			if(rank[rootA]>rank[rootB]) {
				parent[rootB]=rootA;
			}
			else if(rank[rootA]<rank[rootB]) {
				parent[rootA]=rootB;
			}
			else {
				parent[rootA]=rootB;
				rank[rootA]++;
			}
		}
	}
	
	static int find(int a) {
		if(a!=parent[a]) {
			parent[a]=find(parent[a]);
		}
		return parent[a];
	}

}
