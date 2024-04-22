import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] array=new int[2000000];
		int first=0;
		int last=0;
		StringBuilder sb=new StringBuilder();
		
		for(int n=0;n<N;n++) {
			st=new StringTokenizer(br.readLine());
			String input=st.nextToken();
			
			if(input.equals("push")) {
				array[last++]=Integer.parseInt(st.nextToken());
			}
			else if(input.equals("pop")) {
				if(first==last) {
					sb.append("-1\n");
				}
				else {
					sb.append(array[first++]+"\n");
				}
			}
			else if(input.equals("size")) {
				sb.append((last-first)+"\n");
			}
			else if(input.equals("empty")) {
				sb.append((first==last?1:0)+"\n");
			}
			else if(input.equals("back")) {
				sb.append(first==last?"-1\n":(array[last-1]+"\n"));
			}
			else if(input.equals("front")) {
				if(first==last) {
					sb.append("-1\n");
				}
				else {
					sb.append(array[first]+"\n");
				}
			}
		}
		bw.write(sb.toString());
		bw.close();
	}

}
