import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			
			int[] array=new int[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int a=Integer.parseInt(st.nextToken());
				array[i]=a;
			}
			
			long answer=0;
			int now=0;
			while(now<N) {
				long sum=0;
				int idx=0;
				long max=0;
				for(int i=now;i<N;i++) {
					if(array[i]>=max) {
						idx=i;
						max=array[i];
					}
				}
				
				for(int i=now;i<idx;i++) {
					sum+=array[i];
				}
				answer+=max*(idx-now)-sum;
				now=idx+1;
				
			}
			bw.write(answer+"\n");
		}
		bw.close();
	}

}
