import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] v=new int[10001];
		for(int i=0;i<N;i++) {
			v[Integer.parseInt(br.readLine())]++;
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<10001;i++) {
			for(int j=0;j<v[i];j++) {
				sb.append(i).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.close();

	}

}
