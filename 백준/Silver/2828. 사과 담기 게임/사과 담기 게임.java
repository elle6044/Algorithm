import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int J=Integer.parseInt(br.readLine());
		int answer=0;
		int idx=1;
		for(int i=0;i<J;i++) {
			int a=Integer.parseInt(br.readLine());
			if(a<idx) {
				answer+=idx-a;
				idx=a;
			}
			else if(a>idx+(M-1)) {
				answer+=a-(idx+(M-1));
				idx=a-(M-1);
			}
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
