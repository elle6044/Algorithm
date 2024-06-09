import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		
		int[] array=new int[N];
		Arrays.fill(array, 1);
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<S;i++) {
			int a=Integer.parseInt(st.nextToken())-1;
			array[a]=0;
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			int a=Integer.parseInt(st.nextToken())-1;
			array[a]++;
		}
		
		int cnt=0;
		for(int i=0;i<N;i++) {
			if(array[i]==0) {
				for(int d=0;d<2;d++) {
					int n=i+dir[d];
					if(n>=0&&n<N) {
						if(array[n]==2) {
							array[n]=1;
							array[i]=1;
							break;
						}
					}
				}
				if(array[i]==0) cnt++;
			}
		}
		
		bw.write(cnt+"");
		bw.close();
	}

	static int[] dir= {-1,1};
}
