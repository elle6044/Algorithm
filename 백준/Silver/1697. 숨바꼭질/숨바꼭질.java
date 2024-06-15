import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,K;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		v=new boolean[K*2];
		
		int answer=0;
		if(K<=N) {
			answer=N-K;
		}
		else {
			Queue<Integer>q=new ArrayDeque();
			q.offer(N);
			v[N]=true;
			L:while(!q.isEmpty()) {
				int size=q.size();
				for(int s=0;s<size;s++) {
					int a=q.poll();
					if(a==K) break L;
					if(a-1>=0&&!v[a-1]) {
						q.offer(a-1);
						v[a-1]=true;
					}
					if(a+1<=K&&!v[a+1]) {
						q.offer(a+1);
						v[a+1]=true;
					}
					if(a*2<K*2&&!v[a*2]) {
						q.offer(a*2);
						v[a*2]=true;
					}
				}
				answer++;
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
