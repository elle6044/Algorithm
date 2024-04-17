import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());

		Stack<Integer> stack=new Stack();
		stack.push(0);
		int cnt=1;
		for(int n=1;n<=N;n++) {
			int num=Integer.parseInt(br.readLine());
			
			int pre=stack.peek();
			if(pre==num) {
				stack.pop();
				sb.append("-");
			}
			else if(pre<num) {
				for(int i=cnt;i<=num;i++) {
					stack.push(i);
					cnt++;
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-");
			}
			else {
				sb=new StringBuilder("NO");
				break;
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}

}
