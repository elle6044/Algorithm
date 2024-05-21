import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[] array;
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		int max=0;
		for(int i=0;i<N;i++) {
			int a=Integer.parseInt(st.nextToken());
			array[i]=a;
			max=Math.max(max, a);
		}
		M=Integer.parseInt(br.readLine());
		
		int high=max;
		int low=1;
		int answer=0;
		
		while(high>=low) {
			int mid=(high+low)/2;
			int sum=getSum(mid);
			
			if(sum>M) {
				high=mid-1;
			}
			else {
				answer=mid;
				low=mid+1;
			}
		}
		
		bw.write(answer+"");
		bw.close();

	}
	
	static int getSum(int mid) {
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=Math.min(array[i], mid);
		}
		return sum;
	}

}
