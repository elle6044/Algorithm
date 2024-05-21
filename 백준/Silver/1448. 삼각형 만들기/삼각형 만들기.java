import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq=new PriorityQueue(Comparator.reverseOrder());
		for(int i=0;i<N;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int a=pq.poll();
		int b=pq.poll();
		int c=pq.poll();
		
		int answer=-1;
		while(b+c<=a&&!pq.isEmpty()) {
			a=b;
			b=c;
			c=pq.poll();
		}
		if(b+c>a) {
			answer=a+b+c;
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
