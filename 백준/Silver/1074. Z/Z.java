import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,R,C,size;
	
	static int cnt=0;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		size=(int)Math.pow(2, N);
		
		draw(size,0,0);

		bw.write(answer+"");
		bw.close();
	}
	static int answer;
	static void draw(int size, int r, int c) {
		if(R==r&&C==c) {
			answer=cnt;
		}
		if(size==0) {
			return;
		}
		int ns=size/2;
		int nr=r+ns;
		int nc=c+ns;
		
		if(R<nr&&C<nc) {
			draw(ns,r,c);
		}
		else if(R<nr&&C>=nc) {
			cnt+=ns*ns;
			draw(ns,r,nc);
		}
		else if(R>=nr&&C<nc) {
			cnt+=ns*ns*2;
			draw(ns,nr,c);
		}
		else {
			cnt+=ns*ns*3;
			draw(ns,nr,nc);
		}
	}

}
