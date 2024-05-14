import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		int H=Integer.parseInt(st.nextToken());
		int W=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int answer=(H/(N+1)+(H%(N+1)==0?0:1))*(W/(M+1)+(W%(M+1)==0?0:1));
		bw.write(answer+"");
		bw.close();
		
	}

}
