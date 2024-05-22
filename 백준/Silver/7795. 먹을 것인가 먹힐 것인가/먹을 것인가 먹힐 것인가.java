import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> A=new PriorityQueue(Comparator.reverseOrder());
			PriorityQueue<Integer> B=new PriorityQueue(Comparator.reverseOrder());
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				A.offer(Integer.parseInt(st.nextToken()));
			}
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				B.offer(Integer.parseInt(st.nextToken()));
			}
			
			int answer=0;
			while(!A.isEmpty()&&!B.isEmpty()) {
				int a=A.peek();
				int b=B.peek();
				if(a>b) {
					answer+=B.size();
					A.poll();
				}
				else {
					B.poll();
				}
			}
			
			bw.write(answer+"\n");
			
		}
		bw.close();
	}

}
