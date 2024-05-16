import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		int[] array=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		
		int a=0;
		int b=N-1;
		int cnt=0;
		while(a<b) {
			int w=array[a]+array[b];
			if(w==M) {
				cnt++;
				a++;
				b--;
			}
			else if(w<M) {
				a++;
			}
			else if(w>M) {
				b--;
			}
		}
		
		bw.write(cnt+"");
		bw.close();

	}

}
