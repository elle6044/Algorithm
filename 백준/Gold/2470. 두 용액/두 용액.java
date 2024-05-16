import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq=new PriorityQueue(com);
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		int min=Integer.MAX_VALUE;
		int[] answer=new int[2];
		int pre=pq.poll();
		while(!pq.isEmpty()) {
			int now=pq.poll();
			int gap=Math.abs(now+pre);
			if(gap<min) {
				min=gap;
				answer[0]=pre;
				answer[1]=now;
			}
			pre=now;
		}
		Arrays.sort(answer);
		
		bw.write(answer[0]+" "+answer[1]);
		bw.close();
	}
	
	static Comparator<Integer> com=new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(Math.abs(o1), Math.abs(o2));
		}
	};

}
