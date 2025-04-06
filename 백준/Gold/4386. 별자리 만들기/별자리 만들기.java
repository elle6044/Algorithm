import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static Node[] nodeArray;
	static List<Edge> edgeList=new ArrayList<>();
	static int[] parent, rank;
	
	static class Edge implements Comparable<Edge>{
		int s,e;
		double w;
		public Edge(int s, int e, double w) {
			this.s=s;
			this.e=e;
			this .w=w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w<=o.w?-1:1;
		}
	}
	
	static class Node{
		double x,y;
		public Node(double x, double y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		
		nodeArray=new Node[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			double x=Double.parseDouble(st.nextToken());
			double y=Double.parseDouble(st.nextToken());
			
			nodeArray[i]=new Node(x,y);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				int s=i;
				int e=j;
				Node node1=nodeArray[i];
				Node node2=nodeArray[j];
				
				double w=Math.sqrt(Math.pow(node1.x-node2.x, 2)+Math.pow(node1.y-node2.y, 2));
				
				edgeList.add(new Edge(s, e, w));
			}
		}
		
		Collections.sort(edgeList);
		
		parent=new int[N];
		rank=new int[N];
		for(int i=0;i<N;i++) {
			parent[i]=i;
			rank[i]=0;
		}
		
		int cnt=0;
		double answer=0;
		
		for(Edge edge : edgeList) {
			int rootA=find(edge.s);
			int rootB=find(edge.e);
			
			if(rootA!=rootB) {
				cnt++;
				answer+=edge.w;
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
		if(parent[a]!=a) {
			parent[a]=find(parent[a]);
		}
		return parent[a];
	}
}
