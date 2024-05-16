import java.util.*;
import java.io.*;
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
		
		int X=Integer.parseInt(br.readLine());
		
		int head=0;
		int tail=N-1;
		
		int cnt=0;
		while(head<tail) {
			int sum=array[head]+array[tail];
			if(sum>X) {
				tail--;
			}
			else if(sum<X) {
				head++;
			}
			else if(sum==X) {
				cnt++;
				head++;
				tail--;
			}
		}
		bw.write(cnt+"");
		bw.close();

	}

}
