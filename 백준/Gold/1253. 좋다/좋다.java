import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] array=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		
		
		int cnt=0;
		int pre=Integer.MAX_VALUE;
		for(int i=N-1;i>=0;i--) {
			int num=array[i];
			if(num==pre) {
				cnt++;
				continue;
			}
			int a=0;
			int b=N-1;
			while(a<b) {
				if(a==i) {
					a++;
					continue;
				}
				if(b==i) {
					b--;
					continue;
				}
				
				int sum=array[a]+array[b];
				if(sum==num) {
					cnt++;
					pre=num;
					break;
				}
				else if(sum>num) {
					b--;
				}
				else if(sum<num) {
					a++;
				}
			}
		}

		
		bw.write(cnt+"");
		bw.close();

	}

}
