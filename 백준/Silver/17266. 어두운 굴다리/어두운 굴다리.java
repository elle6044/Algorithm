import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[] array;;
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		array=new int[M];
		st=new StringTokenizer(br.readLine());
		int max=0;
		for(int i=0;i<M;i++) {
			int a=Integer.parseInt(st.nextToken());
			array[i]=a;
			max=Math.max(max, a);
		}
		
		int high=N;
		int low=1;
		int answer=0;
		
		while(high>=low) {
			int mid=(high+low)/2;
			boolean check=getCheck(mid);
			
			if(check) {
				answer=mid;
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		bw.write(answer+"");
		bw.close();
	}
	
	static boolean getCheck(int mid) {
		int idx=0;
		for(int i=0;i<M;i++) {
			int left=array[i]-mid;
			int right=array[i]+mid;
			if(left<=idx) {
				idx=right;
			}
			else {
				return false;
			}
		}
		return idx>=N;
	}

}
