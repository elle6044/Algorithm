import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		
		int[] array=new int[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			array[i]=A-B;
		}
		
		Arrays.sort(array);
		
		int answer=0;
		if(N%2==0) {
			int mid1=array[N/2-1];
			int mid2=array[N/2];
			answer=Math.abs(mid1-mid2)+1;
			
		}
		else {
			answer=1;
		}
		
		bw.write(answer+"");
		bw.close();
		

	}

}
