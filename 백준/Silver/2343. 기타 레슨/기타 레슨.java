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
		
		int max=0;
		int sum=0;
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int a=Integer.parseInt(st.nextToken());
			array[i]=a;
			sum+=a;
			max=Math.max(max, a);
		}
		
		int high=sum;
		int low=max;
		
		while(high>=low) {
			int mid=(high+low)/2;
			int cnt=getCnt(mid);
			
			if(cnt<=M) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		
		int cnt=getCnt(high);
		while(true) {
			int temp=getCnt(++high);
			if(cnt!=temp) {
				break;
			}
		}
		
		bw.write(high+"");
		bw.close();
	}
	
	static int getCnt(int mid) {
		int cnt=1;
		int sum=0;
		for(int i=0;i<N;i++) {
			int a=array[i];
			if(sum+a>mid) {
				cnt++;
				sum=a;
			}
			else {
				sum+=a;
			}
		}
		return cnt;
	}

}
