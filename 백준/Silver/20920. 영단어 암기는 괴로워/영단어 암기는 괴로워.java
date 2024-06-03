import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map=new HashMap();
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			if(input.length()>=M) {
				map.put(input, map.getOrDefault(input, 0)+1);
			}
		}
		
		PriorityQueue<Point> pq=new PriorityQueue();
		for(String key:map.keySet()) {
			pq.offer(new Point(key, map.get(key)));
		}
		
		while(!pq.isEmpty()) {
			bw.write(pq.poll().word+"\n");
		}
		bw.close();

	}
	
	static class Point implements Comparable<Point>{
		String word;
		int cnt;
		public Point(String word, int cnt) {
			this.word=word;
			this.cnt=cnt;
		}
		
		@Override
		public int compareTo(Point o) {
			return o.cnt==this.cnt?o.word.length()==this.word.length()?this.word.compareTo(o.word):Integer.compare(o.word.length(), this.word.length()):Integer.compare(o.cnt, this.cnt);
		}
	}

}
