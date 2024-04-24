import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());

		PriorityQueue<Integer>pq=new PriorityQueue(com);
		for(int n=0;n<N;n++) {
			int input=Integer.parseInt(br.readLine());
			if(input==0) {
				if(pq.isEmpty()) {
					bw.write("0\n");
				}
				else {
					bw.write(pq.poll()+"\n");
				}
			}
			else {
				pq.offer(input);
			}
		}
		bw.close();
	}
	
	static Comparator<Integer> com=new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			int a=Math.abs(o1);
			int b=Math.abs(o2);
			if(a==b) {
				return Integer.compare(o1, o2);
			}
			else {
				return Integer.compare(a, b);
			}
		}
	};

}
