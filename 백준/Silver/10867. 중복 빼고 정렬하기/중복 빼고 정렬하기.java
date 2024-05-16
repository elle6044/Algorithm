import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		boolean[] v=new boolean[2001];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			v[Integer.parseInt(st.nextToken())+1000]=true;
		}
		
		for(int i=0;i<2001;i++) {
			if(v[i]) bw.write((i-1000)+" ");
		}
		bw.close();
	}

}
