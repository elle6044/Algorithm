import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq=new PriorityQueue();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		int x=0;
		int cnt=0;
		while(!pq.isEmpty()) {
			int idx=pq.poll();
			if(x<=idx) {
				cnt++;
				x=idx+L;
			}
		}
		
		bw.write(cnt+"");
		bw.close();

	}

}
