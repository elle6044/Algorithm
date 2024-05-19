import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int min1=Integer.MAX_VALUE;
		int min2=Integer.MAX_VALUE;
		
		for(int i=0;i<M;i++){
			st=new StringTokenizer(br.readLine());
			min1=Math.min(min1, Integer.parseInt(st.nextToken()));
			min2=Math.min(min2, Integer.parseInt(st.nextToken()));
		}
		
		int sum=0;
		if(min1>=min2*6) {
			sum=min2*N;
		}
		else {
			sum+=N/6*min1;
			N%=6;
			if(min1>=min2*N) {
				sum+=min2*N;
			}
			else {
				sum+=min1;
			}
		}
		bw.write(sum+"");
		bw.close();
	}

}
