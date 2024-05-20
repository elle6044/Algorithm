import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		
		boolean[] v=new boolean[N];
		PriorityQueue<Integer> pq=new PriorityQueue();
		
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine())-1;
			if(num>=N) {
				pq.offer(num);
			}
			else {
				if(v[num]) {
					pq.offer(num);
				}
				else {
					v[num]=true;
				}
			}
		}
		
		long answer=0;
		for(int i=0;i<N;i++) {
			if(!v[i]) {
				answer+=Math.abs(i-pq.poll());
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
