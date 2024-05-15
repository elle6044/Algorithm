import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		boolean[] v=new boolean[2000001];
		for(int i=0;i<N;i++) {
			v[Integer.parseInt(br.readLine())+1000000]=true;
		}
		
		for(int i=0;i<2000001;i++) {
			if(v[i]) {
				bw.write((i-1000000)+"\n");
			}
		}
		
		bw.close();

	}

}
