import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		for(int t=1;t<=10;t++) {
			int N=Integer.parseInt(br.readLine());
			Deque<Integer> dq=new ArrayDeque();
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				dq.offerLast(Integer.parseInt(st.nextToken()));
			}
			
			int M=Integer.parseInt(br.readLine());
			Stack<Integer> stack=new Stack();
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				
				String com=st.nextToken();
				if(com.equals("I")) {
					int x=Integer.parseInt(st.nextToken());
					int y=Integer.parseInt(st.nextToken());
					
					for(int j=0;j<x;j++) {
						stack.push(dq.pollFirst());
					}
					for(int j=0;j<y;j++) {
						stack.push(Integer.parseInt(st.nextToken()));
					}
					
					while(!stack.isEmpty()) {
						dq.offerFirst(stack.pop());
					}
				}
				else if(com.equals("D")) {
					int x=Integer.parseInt(st.nextToken());
					int y=Integer.parseInt(st.nextToken());
					
					for(int j=0;j<x;j++) {
						stack.push(dq.pollFirst());
					}
					for(int j=0;j<y;j++) {
						dq.pollFirst();
					}
					
					while(!stack.isEmpty()) {
						dq.offerFirst(stack.pop());
					}
				}
				else if(com.equals("A")) {
					int y=Integer.parseInt(st.nextToken());
					for(int j=0;j<y;j++) {
						dq.offerLast(Integer.parseInt(st.nextToken()));
					}
				}
			}
			
			bw.write("#"+t);
			for(int i=0;i<10;i++) {
				bw.write(" "+dq.pollFirst());
			}
			bw.write("\n");
		}
		bw.close();
	}

}
