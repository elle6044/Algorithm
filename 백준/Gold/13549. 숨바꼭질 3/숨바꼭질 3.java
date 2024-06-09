import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,K;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		int answer=Integer.MAX_VALUE;
		
		if(N>=K) {
			answer=N-K;
		}
		else {
			int[] array=new int[2*K+1];
			Arrays.fill(array, Integer.MAX_VALUE);
			array[N]=0;
			
			Queue<Integer> q=new ArrayDeque();
			q.offer(N);
			
			while(!q.isEmpty()) {
				int output=q.poll();
				int n=output-1;
				if(check(n)) {
					if(array[output]+1<array[n]) {
						q.offer(n);
						array[n]=array[output]+1;
					}
				}
				n=output+1;
				if(check(n)) {
					if(array[output]+1<array[n]) {
						q.offer(n);
						array[n]=array[output]+1;
					}
				}
				n=output*2;
				if(check(n)) {
					if(array[output]<array[n]) {
						q.offer(n);
						array[n]=array[output];
					}
				}
			}
			answer=array[K];
		}
		bw.write(answer+"");
		bw.close();
	}
	
	static boolean check(int n) {
		if(n>=0&&n<=2*K) {
			return true;
		}
		else {
			return false;
		}
	}

}
