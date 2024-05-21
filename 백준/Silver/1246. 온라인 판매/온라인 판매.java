import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer>pq=new PriorityQueue(Comparator.reverseOrder());
		for(int i=0;i<M;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int answer=0;
		int min=Integer.MAX_VALUE;
		int cnt=0;
		while(cnt<N&&!pq.isEmpty()) {
			int p=pq.poll();
			cnt++;
			if(p*cnt>=answer) {
				answer=p*cnt;
				min=p;
			}
		}
		
		bw.write(min+" "+answer);
		bw.close();
		

	}

}
