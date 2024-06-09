import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq=new PriorityQueue();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		int cnt=0;
		int need=N-1;
		while(need>0) {
			int output=pq.poll();
			if(output<need) {
				need--;
				need-=output;
				cnt+=output;
			}
			else {
				cnt+=need;
				need=0;
			}
		}
		bw.write(cnt+"");
		bw.close();
	}

}
