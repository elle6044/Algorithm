import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		Deque<Integer>dq=new ArrayDeque();
		int N=Integer.parseInt(br.readLine());
		for(int n=0;n<N;n++) {
			st=new StringTokenizer(br.readLine());
			String input=st.nextToken();
			
			if(input.equals("push_front")) {
				dq.offerFirst(Integer.parseInt(st.nextToken()));
			}
			else if(input.equals("push_back")) {
				dq.offerLast(Integer.parseInt(st.nextToken()));
			}
			else if(input.equals("pop_front")) {
				if(dq.isEmpty()) {
					bw.write("-1\n");
				}
				else {
					bw.write(dq.pollFirst()+"\n");
				}
			}
			else if(input.equals("pop_back")) {
				if(dq.isEmpty()) {
					bw.write("-1\n");
				}
				else {
					bw.write(dq.pollLast()+"\n");
				}
			}
			else if(input.equals("size")) {
				bw.write(dq.size()+"\n");
			}
			else if(input.equals("empty")) {
				bw.write(dq.isEmpty()?"1\n":"0\n");
			}
			else if(input.equals("front")) {
				if(dq.isEmpty()) {
					bw.write("-1\n");
				}
				else {
					bw.write(dq.peekFirst()+"\n");
				}
			}
			else if(input.equals("back")) {
				if(dq.isEmpty()) {
					bw.write("-1\n");
				}
				else {
					bw.write(dq.peekLast()+"\n");
				}
			}
		}
		bw.close();
	}

}
