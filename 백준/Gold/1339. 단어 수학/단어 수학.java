import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		Map<Character,Point> map=new HashMap();
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<input.length();j++) {
				char word=input.charAt(j);
				Point p;
				if(map.containsKey(word)) {
					p=map.get(word);
				}
				else {
					p=new Point();
					map.put(word, p);
				}
				p.cnt++;
				p.word[input.length()-j]++;
				if(j<input.length()-1&&p.word[input.length()-j]==10) {
					p.word[input.length()-j+1]++;
					p.word[input.length()-j]=0;
				}
			}
		}
		
		PriorityQueue<Point> pq=new PriorityQueue();
		for(char key:map.keySet()) {
			pq.offer(map.get(key));
		}
		
		int sum=0;
		int num=9;
		while(!pq.isEmpty()) {
			Point p=pq.poll();
			for(int i=1;i<9;i++) {
				int zero=1;
				for(int j=1;j<i;j++) {
					zero*=10;
				}
				sum+=zero*num*p.word[i];
			}
			num--;
		}
		
		bw.write(sum+"");
		bw.close();
	}

	static class Point implements Comparable<Point>{
		int cnt=0;
		int[] word=new int[9];
		public Point() {};
		@Override
		public int compareTo(Point o) {
			for(int i=8;i>=1;i--) {
				if(this.word[i]>o.word[i]) {
					return -1;
				}
				else if(this.word[i]<o.word[i]) {
					return 1;
				}
			}
			return -1;
		}
		
	}
}
