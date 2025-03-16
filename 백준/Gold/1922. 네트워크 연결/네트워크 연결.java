import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int V,E;
	static List<Edge> edgeList;
	static int[] parent,rank;
	
	public static void main(String[] args) throws Exception{
		V=Integer.parseInt(br.readLine());
		E=Integer.parseInt(br.readLine());
		
		edgeList=new ArrayList<>(E);
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(s,e,w));
		}
		Collections.sort(edgeList);
		
		parent=new int[V];
		rank=new int[V];
		for(int i=0;i<V;i++) {
			parent[i]=i;
			rank[i]=0;
		}
		
		int edgeCnt=0;
		int answer=0;
		for(Edge edge : edgeList) {
			int rootA=find(edge.s);
			int rootB=find(edge.e);
			
			if(rootA!=rootB) {
				edgeCnt++;
				answer+=edge.w;
				union(rootA, rootB);
			}
			
			if(edgeCnt==V-1) break;
		}
		
		bw.write(answer+"");
		bw.close();
	}
	
	static int find(int node) {
		if(parent[node]!=node) {
			parent[node]=find(parent[node]);
		}
		return parent[node];
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
				rank[rootB]++;
			}
		}
	}
	
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
}
