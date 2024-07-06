import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	
	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		int[] value=new int[N];
		int[] fee=new int[N];

		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int v=Integer.parseInt(st.nextToken());
			int f=Integer.parseInt(st.nextToken());
			value[i]=v;
			fee[i]=f;
		}
		
		int answer=0;
		int max=0;
		for(int i=0;i<N;i++) {
			int v1=value[i];
			int sum=0;
			for(int j=0;j<N;j++) {
				int v2=value[j];
				if(v1<=v2&&v1-fee[j]>0) {
					sum+=v1-fee[j];
				}
			}
			if(max<sum) {
				max=sum;
				answer=v1;
			}
			else if(max==sum) {
				answer=Math.min(answer, v1);
			}
		}
		
		
		bw.write(answer+"");
		bw.close();
	}
	static class Point implements Comparable<Point>{
		int v,f;
		public Point(int v, int f) {
			this.v=v;
			this.f=f;
		}
		
		@Override
		public int compareTo(Point o) {
			return Integer.compare(o.v, this.v);
		}
		
	}

}
