import java.io.*;
import java.util.*;
public class Solution {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int TC=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			bw.write("#"+tc);
			int N=Integer.parseInt(br.readLine());
			int[] priceArray=new int[N*2];
			boolean[] v=new boolean[N*2];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N*2;i++) {
				priceArray[i]=Integer.parseInt(st.nextToken());
			}
			
			Queue<Integer> queue=new ArrayDeque();
			
			for(int i=0;i<2*N;i++) {
				int price=priceArray[i];
				if(!queue.isEmpty()&&queue.peek()==price) {
					queue.poll();
				}
				else {
					bw.write(" "+price);
					queue.offer(price+price/3);
				}
			}
			bw.write("\n");
		}
		bw.close();
	}

}
