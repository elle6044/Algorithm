import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> pq=new PriorityQueue(Comparator.reverseOrder());
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
			int sum=0;
			for(int i=0;i<K;i++) {
				sum+=pq.poll();
			}
			
			bw.write("#"+t+" "+sum+"\n");
		}
		bw.close();
	}

}
