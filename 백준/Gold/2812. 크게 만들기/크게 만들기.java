import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack=new Stack();
		String input=br.readLine();
		for(int i=0;i<N;i++) {
			int next=input.charAt(i)-48;
			while(!stack.isEmpty()&&K>0) {
				int pre=stack.peek();
				if(pre<next) {
					stack.pop();
					K--;
				}
				else {
					break;
				}
			}
			stack.push(next);
		}
		for(int i=0;i<K;i++) {
			stack.pop();
		}
		
		for(int a:stack) {
			bw.write(a+"");
		}
		bw.close();
	}

}
