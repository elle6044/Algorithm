import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int F,S,G,U,D;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		F=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		G=Integer.parseInt(st.nextToken());
		U=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		
		v=new boolean[F+1];
		
		int answer=0;
		
		Queue<Integer> q=new ArrayDeque();
		q.offer(S);
		v[S]=true;
		L:while(!q.isEmpty()) {
			int size=q.size();
			for(int s=0;s<size;s++) {
				int a=q.poll();
				if(a==G) break L;
				int na=a+U;
				if(na<=F&&!v[na]) {
					q.offer(na);
					v[na]=true;
				}
				na=a-D;
				if(na>=1&&!v[na]) {
					q.offer(na);
					v[na]=true;
				}
			}
			answer++;
		}
		
		if(!v[G]) {
			bw.write("use the stairs");
		}
		else {
			bw.write(answer+"");
		}
		bw.close();

	}

}
