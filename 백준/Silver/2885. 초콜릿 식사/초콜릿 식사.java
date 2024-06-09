import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int size=1;
		while(size<N) {
			size*=2;
		}
		int s=size;
		int cnt=0;
		if(size!=N) {
			while(N>0) {
				cnt++;
				s/=2;
				for(int i=0;i<cnt*2;i++) {
					if(N>=s) {
						N-=s;
					}
				}
			}
		}
		
		bw.write(size+" "+cnt);
		bw.close();
	}

}
