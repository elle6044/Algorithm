import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] array=new int[1001];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[Integer.parseInt(st.nextToken())]++;
		}
		
		int cnt=N;
		int answer=0;
		for(int i=1;i<=1000;i++) {
			for(int j=0;j<array[i];j++) {
				answer+=i*cnt--;
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
