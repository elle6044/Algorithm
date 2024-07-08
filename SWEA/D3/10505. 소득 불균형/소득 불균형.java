import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			PriorityQueue<Integer>pq=new PriorityQueue();
			st=new StringTokenizer(br.readLine());
			double sum=0;
			for(int i=0;i<N;i++) {
				int input=Integer.parseInt(st.nextToken());
				sum+=input;
				pq.offer(input);
			}
			double avg=sum/N;
			int answer=0;
			while(!pq.isEmpty()&&pq.peek()<=avg) {
				answer++;
				pq.poll();
			}
			bw.write("#"+t+" "+answer+"\n");
		}
		bw.close();

	}

}
