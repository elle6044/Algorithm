import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int cnt=1;
		N--;
		while(N>0) {
			N-=6*cnt;
			cnt++;
		}
		bw.write(cnt+"");
		bw.close();
	}
}
