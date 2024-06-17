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
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(br.readLine());
			
			int answer=0;
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				int x3=Integer.parseInt(st.nextToken());
				int y3=Integer.parseInt(st.nextToken());
				double r=Integer.parseInt(st.nextToken());
				double r1=Math.sqrt(Math.pow(x1-x3, 2)+Math.pow(y1-y3, 2));
				double r2=Math.sqrt(Math.pow(x2-x3, 2)+Math.pow(y2-y3, 2));
				
				if(r1<r&&r2<r) {
					continue;
				}
				else {
					if(r1<r||r2<r) {
						answer++;
					}
				}
			}
			
			bw.write(answer+"\n");
		}
		bw.close();
	}

}
