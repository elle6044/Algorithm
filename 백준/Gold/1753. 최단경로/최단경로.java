import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int V,E,K;
	static List<Edge> edgeList[];
	
	static class Edge implements Comparable<Edge>{
		int e,w;
		public Edge(int e, int w) {
			this.e=e;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o){
			return this.w-o.w;
		}
	}
	
	static int[] dist;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(br.readLine())-1;
		
		edgeList=new ArrayList[V];
		for(int i=0;i<V;i++) {
			edgeList[i]=new ArrayList<Edge>();
		}
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			
			edgeList[s].add(new Edge(e,w));
		}
		
		dist=new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K]=0;
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		pq.offer(new Edge(K,0));
		
		while(!pq.isEmpty()) {
			Edge edge=pq.poll();
			
			if(edge.w>dist[edge.e]) continue;
			
			for(Edge next:edgeList[edge.e]) {
				int nw=dist[edge.e]+next.w;
				if(nw<dist[next.e]) {
					dist[next.e]=nw;
					pq.offer(new Edge(next.e,nw));
				}
			}
		}
		
		for(int i=0;i<V;i++) {
			if(dist[i]==Integer.MAX_VALUE) bw.write("INF\n");
			else bw.write(dist[i]+"\n");
		}
		bw.close();
	}
}
