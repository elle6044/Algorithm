import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static List<Integer>[] lists;
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		lists=new ArrayList[N];
		for(int i=0;i<N;i++) {
			lists[i]=new ArrayList();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			lists[s].add(e);
			lists[e].add(s);
		}
		
		Queue<Integer> q=new ArrayDeque();
		boolean[] v=new boolean[N];
		q.offer(0);
		v[0]=true;
		int cnt=0;
		while(!q.isEmpty()) {
			int a=q.poll();
			for(int next:lists[a]) {
				if(!v[next]) {
					q.add(next);
					v[next]=true;
					cnt++;
				}
			}
		}
		
		bw.write(cnt+"");
		bw.close();
	}

}
