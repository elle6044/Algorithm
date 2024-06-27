import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		String input=br.readLine();
		int N=input.length();
		int[] sum=new int[N+1];
		for(int i=1;i<=N;i++) {
			sum[i]=sum[i-1]+(input.charAt(i-1)-48);
		}
		
		int answer=0;
		L:for(int i=N%2==0?N:N-1;i>=2;i-=2) {
			for(int j=0;j<=N-i;j++) {
				int a=sum[i+j]-sum[j];
				int b=sum[i/2+j]-sum[j];
				if(a==b*2) {
					answer=i;
					break L;
				}
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
