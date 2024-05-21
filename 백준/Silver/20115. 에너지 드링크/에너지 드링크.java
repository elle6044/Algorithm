import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		double[] drinks=new double[N];
		for(int i=0;i<N;i++) {
			drinks[i]=Double.parseDouble(st.nextToken());
		}
		Arrays.sort(drinks);
		
		double answer=drinks[N-1];
		for(int i=N-2;i>=0;i--) {
			answer+=drinks[i]/2;
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
