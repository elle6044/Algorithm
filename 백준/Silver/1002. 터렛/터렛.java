import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			double r1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			double r2=Integer.parseInt(st.nextToken());
			
			double r3=Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
			
			int answer=-1;
			if(x1==x2&&y1==y2) {
				if(r1!=r2) {
					answer=0;
				}
			}
			else {
				double a=Math.max(r1, Math.max(r2, r3));
				double b=r1+r2+r3-a;
				if(a==b) {
					answer=1;
				}
				else if(a<b) {
					answer=2;
				}
				else if(a>b) {
					answer=0;
				}
				
			}
			
			bw.write(answer+"\n");
			
		}
		bw.close();
	}

}
