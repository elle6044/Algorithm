import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		int[] array=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		int max=0;
		int cnt=1;
		for(int i=0;i<X;i++) {
			max+=array[i];
		}
		
		int sum=max;
		for(int i=X;i<N;i++) {
			sum-=array[i-X];
			sum+=array[i];
			if(sum>max) {
				max=sum;
				cnt=1;
			}
			else if(sum==max) {
				cnt++;
			}
		}
		if(max==0) {
			bw.write("SAD");
		}
		else {
			bw.write(max+"\n"+cnt);
		}
		
		bw.close();
	}

}
