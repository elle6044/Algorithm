import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,L;
	static int[] array;

	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		array=new int[N];
		for(int i=0;i<N;i++) {
			array[N-1-i]=Integer.parseInt(st.nextToken());
		}
		
		String answer="stable";
		int temp=array[0];
		double sum=array[0];
		for(int i=1;i<N;i++) {
			double avg=sum/i;
			int now=array[i];
			
			if(Math.abs(temp-now)>=L*2) {
				answer="unstable";
				break;
			}
			
			if(Math.abs(avg-now)>=L) {
				answer="unstable";
				break;
			}
			
			sum+=now;
		}
		
		bw.write(answer);
		bw.close();
	}
}
