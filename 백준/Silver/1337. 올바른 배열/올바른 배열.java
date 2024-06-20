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
			array[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);
		
		int answer=5;
		for(int i=0;i<N;i++) {
			int start=array[i];
			int idx=i+1;
			int cnt=4;
			while(idx<N&&array[idx]<start+5) {
				cnt--;
				idx++;
			}
			
			answer=Math.min(answer, cnt);
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
