import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<String> pq=new PriorityQueue(com);
		for(int i=0;i<N;i++) {
			pq.offer(br.readLine());
		}
		
		while(!pq.isEmpty()) {
			bw.write(pq.poll()+"\n");
		}
		bw.close();

	}
	
	static Comparator<String> com=new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			if(o1.length()!=o2.length()) {
				return Integer.compare(o1.length(), o2.length());
			}
			else {
				int a=0;
				int b=0;
				for(int i=0;i<o1.length();i++) {
					if(48<=o1.charAt(i)&&57>=o1.charAt(i)) {
						a+=Character.getNumericValue(o1.charAt(i));
					}
				}
				for(int i=0;i<o2.length();i++) {
					if(48<=o2.charAt(i)&&57>=o2.charAt(i)) {
						b+=Character.getNumericValue(o2.charAt(i));
					}
				}
				if(a!=b) {
					return Integer.compare(a, b);
				}
				else {
					return o1.compareTo(o2);
				}
			}
		}
	};

}
