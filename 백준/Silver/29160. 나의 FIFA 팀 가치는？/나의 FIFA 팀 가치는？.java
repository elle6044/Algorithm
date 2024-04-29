import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer>[]pqs=new PriorityQueue[11];
		for(int i=0;i<11;i++) {
			PriorityQueue<Integer> pq=new PriorityQueue(com);
			pqs[i]=pq;
		}
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			pqs[p].offer(w);
		}
		
		for(int k=0;k<K;k++) {
			for(int i=0;i<11;i++) {
				if(!pqs[i].isEmpty()) {
					int idx=pqs[i].poll();
					if(idx>0) {
						idx--;
					}
					pqs[i].offer(idx);
				}
			}
		}
		
		int answer=0;
		for(int i=0;i<11;i++) {
			if(!pqs[i].isEmpty()) {
				answer+=pqs[i].peek();
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}
	
	static Comparator<Integer> com=new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1<o2) {
				return 1;
			}
			else {
				return -1;
			}
		}
	};
}
