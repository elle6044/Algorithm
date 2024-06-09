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
		PriorityQueue<Integer> npq=new PriorityQueue();
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int P=Integer.parseInt(st.nextToken());
			int L=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			if(P>=L) {
				PriorityQueue<Integer> pq=new PriorityQueue(Comparator.reverseOrder());
				for(int j=0;j<P;j++) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
				
				for(int j=0;j<L-1;j++) {
					pq.poll();
				}
				
				npq.offer(pq.peek());
			}
			else {
				npq.offer(1);
			}
		}
		
		int cnt=0;
		while(!npq.isEmpty()&&M>=0) {
			int a=npq.poll();
			if(M-a>=0) {
				cnt++;
				M-=a;
			}
			else {
				break;
			}
		}
		
		bw.write(cnt+"");
		bw.close();
		
		

	}

}
