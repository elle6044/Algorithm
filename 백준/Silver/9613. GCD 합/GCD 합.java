import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[] array;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			answer=0;
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			array=new int[N];
			for(int i=0;i<N;i++) {
				array[i]=Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0,new int[2]);
			bw.write(answer+"\n");
		}
		bw.close();
	}
	
	static long answer=0;
	static void dfs(int cnt, int idx, int[] num) {
		if(cnt==2) {
			int gcd=getGCD(num[0],num[1]);
			answer+=gcd;
			return;
		}
		if(idx==N) return;
		num[cnt]=array[idx];
		dfs(cnt+1,idx+1,num);
		dfs(cnt,idx+1,num);
	}
	
	static int getGCD(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGCD(b,a%b);
	}

}
