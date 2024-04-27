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
		PriorityQueue<Integer> pq=new PriorityQueue(com);
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int box=Integer.parseInt(st.nextToken());
			pq.offer(box);
		}
		
		int answer=1;
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int kid=Integer.parseInt(st.nextToken());
			int box=pq.poll();
			if(kid>box) {
				answer=0;
				break;
			}
			pq.offer(box-kid);
		}
		
		bw.write(answer+"");
		bw.close();
	}
	
	static Comparator<Integer> com=new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1>o2) {
				return -1;
			}
			else {
				return 1;
			}
		}
	};

}
