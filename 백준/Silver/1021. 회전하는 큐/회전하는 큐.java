import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		Deque<Integer> dq=new ArrayDeque();
		for(int i=0;i<N;i++) {
			dq.offer(i+1);
		}
		
		int answer=0;
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int input=Integer.parseInt(st.nextToken());
			
			int cnt=0;
			while(dq.peek()!=input) {
				dq.offer(dq.poll());
				cnt++;
			}
			answer+=Math.min(cnt, dq.size()-cnt);
			dq.poll();
			
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
