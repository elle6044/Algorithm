import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] array=new int[100001];
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		int max=0;
		int cnt=0;
		Queue<Integer> q=new ArrayDeque();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int input=Integer.parseInt(st.nextToken());
			if(array[input]<K) {
				array[input]++;
				cnt++;
				q.offer(input);
				max=Math.max(max, cnt);
			}
			else {
				while(true) {
					int output=q.poll();
					if(input==output) {
						q.offer(input);
						break;
					}
					else {
						array[output]--;
						cnt--;
					}
				}
			}
		}
		
		bw.write(max+"");
		bw.close();

	}

}
