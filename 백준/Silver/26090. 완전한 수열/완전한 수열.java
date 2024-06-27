import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[] array;
	static boolean[] prime=new boolean[1000001];
	
	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		getPrime();
		
		int answer=0;
		for(int i=2;i<=N;i++) {
			if(prime[i]) {
				int len=i;
				int sum=0;
				for(int j=0;j<len;j++) {
					sum+=array[j];
				}
				if(prime[sum]) answer++;
				
				for(int j=len;j<N;j++) {
					sum+=array[j]-array[j-len];
					if(prime[sum]) answer++;
				}
			}
		}
		
		bw.write(answer+"");
		bw.close();
		
	}

	static void getPrime() {
		Arrays.fill(prime, true);
		prime[0]=false;
		prime[1]=false;
		
		for(long i=2;i<=1000000;i++) {
			if(prime[(int)i]) {
				for(long j=i*i;j<=1000000;j+=i) {
					prime[(int)j]=false;
				}
			}
		}
	}
}
