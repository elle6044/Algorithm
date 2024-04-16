import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		Queue<Integer>q=new ArrayDeque();
		for(int n=0;n<N;n++) {
			st=new StringTokenizer(br.readLine());
			String input=st.nextToken();
			if(input.equals("push")) {
				q.offer(Integer.parseInt(st.nextToken()));
				continue;
			}
			else if(input.equals("pop")) {
				if(q.isEmpty()) {
					bw.write("-1");
				}
				else {
					bw.write(q.poll()+"");
				}
			}
			else if(input.equals("size")) {
				bw.write(q.size()+"");
			}
			else if(input.equals("empty")) {
				int a=q.isEmpty()?1:0;
				bw.write(a+"");
			}
			else if(input.equals("front")) {
				if(q.isEmpty()) {
					bw.write("-1");
				}
				else {
					bw.write(q.peek()+"");
				}
			}
			else if(input.equals("back")) {
				if(q.isEmpty()) {
					bw.write("-1");
				}
				else {
					int a=0;
					for(int b:q) {
						a=b;
					}
					bw.write(a+"");
				}
			}
			bw.write("\n");
		}
		bw.close();
	}

}
