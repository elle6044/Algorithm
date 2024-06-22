import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static boolean[] prime=new boolean[1000001];
	public static void main(String[] args) throws Exception{
		getPrime();
		
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
			
			int left=2;
			int right=N;
			
			int answer=0;
			while(left<=right) {
				if(!prime[left]) {
					left++;
					continue;
				}
				if((!prime[right])) {
					right--;
					continue;
				}
				
				int sum=left+right;
				if(sum==N) {
					answer++;
					left++;
					right--;
				}
				else if(sum>N) {
					right--;
				}
				else if(sum<N) {
					left++;
				}
			}
			
			bw.write(answer+"\n");
		}
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
