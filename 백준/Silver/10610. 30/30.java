import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		String input=br.readLine();
		PriorityQueue<Integer>pq=new PriorityQueue(com);
		int sum=0;
		boolean check=false;
		for(int i=0;i<input.length();i++) {
			char a=input.charAt(i);
			int num=a-48;
			pq.offer(num);
			sum+=num;
			if(num==0) check=true;
		}
		if(sum%3!=0||!check) {
			bw.write("-1");
		}
		else {
			while(!pq.isEmpty()) {
				bw.write(pq.poll()+"");;
			}
		}

		
		bw.close();

	}
	
	static Comparator<Integer> com=new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1<=o2) {
				return 1;
			}
			else {
				return -1;
			}
		}
	};

}
