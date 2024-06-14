import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static List<Integer>[] lists;
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		int t1=Integer.parseInt(st.nextToken());
		int t2=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(br.readLine());
		
		lists=new ArrayList[N+1];
		for(int i=0; i<=N;i++) {
			lists[i]=new ArrayList();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			lists[s].add(e);
			lists[e].add(s);
		}
		
		Queue<Integer> q=new ArrayDeque();
		boolean[] v=new boolean[N+1];
		q.offer(t1);
		v[t1]=true;
		
		int answer=0;
		boolean check=false;
		L:while(!q.isEmpty()) {
			int size=q.size();
			for(int s=0;s<size;s++) {
				int a=q.poll();
				if(a==t2) {
					check=true;
					break L;
				}
				for(int next:lists[a]) {
					if(!v[next]) {
						q.add(next);
						v[next]=true;
					}
				}
			}
			answer++;
		}
		if(!check) answer=-1;
		bw.write(answer+"");
		bw.close();
	}

}
