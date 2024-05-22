import java.util.*;
import java.io.*;
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
		array=new int[N];
		
		int max=0;
		int sum=0;
		for(int i=0;i<N;i++) {
			int a=Integer.parseInt(br.readLine());
			array[i]=a;
			sum+=a;
			max=Math.max(max, a);
		}
		
		int high=sum;
		int low=max;
		int answer=0;
		
		while(high>=low) {
			int mid=(high+low)/2;
			int cnt=getCnt(mid);
			
			if(cnt>M) {
				low=mid+1;
			}
			else {
				high=mid-1;
			}
		}
		
		bw.write(++high+"");
		bw.close();

	}
	
	static int getCnt(int mid) {
		int cnt=1;
		int sum=0;
		for(int i=0;i<N;i++) {
			int money=array[i];
			if(sum+money<=mid) {
				sum+=money;
			}
			else {
				cnt++;
				sum=money;
			}
		}
		return cnt;
	}

}
