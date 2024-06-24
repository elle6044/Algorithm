import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[] array;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		array=new int[N+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			array[i]=array[i-1]+Integer.parseInt(st.nextToken());
		}
		int answer=0;
		int left=1;
		int right=1;
		while(left<=right) {
			int num=array[right]-array[left-1];
			if(num==M) {
				answer++;
				right++;
				left++;
			}
			else if(num<M) {
				right++;
			}
			else if(num>M) {
				left++;
				if(left>right) {
					right++;
				}
			}
			if(right>N||left>N) break;
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
