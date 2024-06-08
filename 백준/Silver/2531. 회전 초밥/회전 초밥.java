import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		int[] array=new int[N];
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		int[] check=new int[d+1];
		
		int answer=0;
		int cnt=0;
		
		for(int i=0;i<k;i++) {
			if(check[array[i]]==0) cnt++;
			check[array[i]]++;
		}
		
		for(int i=k;i<N+k;i++) {
			int input=array[i%N];
			int output=array[i-k];
			
			check[output]--;
			if(check[input]==0) cnt++;
			if(check[output]==0) cnt--;
			check[input]++;
			
			answer=Math.max(answer, cnt+(check[c]==0?1:0));
		}
		bw.write(answer+"");
		bw.close();
	}

}
