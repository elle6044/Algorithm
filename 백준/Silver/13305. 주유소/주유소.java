import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] dist=new int[N-1];
		int[] price=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) {
			dist[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			price[i]=Integer.parseInt(st.nextToken());
		}
		
		int minP=price[0];
		int minD=0;
		int sum=0;
		for(int i=0;i<N-1;i++) {
			int pre=i;
			int next=i+1;
			
			minD+=dist[i];
			if(price[next]<minP) {
				sum+=minP*minD;
				minP=price[next];
				minD=0;
			}
		}
		sum+=minP*minD;
		
		bw.write(sum+"");
		bw.close();
	}

}
