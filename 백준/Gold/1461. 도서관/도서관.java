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
		
		PriorityQueue<Integer> left=new PriorityQueue(Comparator.reverseOrder());
		PriorityQueue<Integer> right=new PriorityQueue(Comparator.reverseOrder());
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int input=Integer.parseInt(st.nextToken());
			if(input<0) {
				left.offer(Math.abs(input));
			}
			else {
				right.offer(input);
			}
		}
		
		int answer=0;
		
		PriorityQueue<Integer> pq=new PriorityQueue(Comparator.reverseOrder());
		int cnt=0;
		while(!left.isEmpty()) {
			int num=left.poll();
			if(cnt%M==0) {
				pq.offer(num);
			}
			cnt++;
		}
		
		cnt=0;
		while(!right.isEmpty()) {
			int num=right.poll();
			if(cnt%M==0) {
				pq.offer(num);
			}
			cnt++;
		}
		
		answer+=pq.poll();
		while(!pq.isEmpty()) {
			answer+=pq.poll()*2;
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
