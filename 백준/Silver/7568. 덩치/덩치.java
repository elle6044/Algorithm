import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		Point[] array=new Point[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int w=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			array[i]=new Point(w,h);
		}
		
		for(int i=0;i<N;i++) {
			int cnt=1;
			Point a=array[i];
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				Point b=array[j];
				if(b.w>a.w&&b.h>a.h) cnt++;
			}
			bw.write(cnt+" ");
		}
		bw.close();

	}
	
	static class Point{
		int w,h;
		public Point(int w, int h) {
			this.w=w;
			this.h=h;
		}
	}

}
