import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		int[] array=new int[N];
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		Deque<Integer> dq=new ArrayDeque();
		
		int answer=0;
		int cnt=0;
		
		for(int i=0;i<k;i++) {
			if(!dq.contains(array[i])) cnt++;
			dq.offer(array[i]);
		}
		
		for(int i=k;i<N+k;i++) {
			int input=array[i%N];
			int output=dq.poll();
			
			if(!dq.contains(input)) cnt++;
			if(!dq.contains(output)) cnt--;
			
			dq.offer(input);
			answer=Math.max(answer, cnt+(dq.contains(c)?0:1));
		}
		bw.write(answer+"");
		bw.close();
	}

}
