import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] array;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			array=new int[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				array[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(array);
			
			int idx=1;
			int left=array[idx++];
			int right=array[idx++];
			int answer=Math.max(Math.abs(array[0]-left), Math.abs(array[0]-right));
			
			while(true) {
				if(idx<N) {
					int nl=array[idx++];
					answer=Math.max(answer, Math.abs(left-nl));
					left=nl;
				}
				else {
					break;
				}
				
				if(idx<N) {
					int nr=array[idx++];
					answer=Math.max(answer, Math.abs(right-nr));
					right=nr;
				}
				else {
					break;
				}
			}
			answer=Math.max(answer, Math.abs(right-left));
			
			bw.write(answer+"\n");
		}
		bw.close();

	}

}
