import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		
		int[] array=new int[N];
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		
		bw.write(array[N%2==0?N/2-1:N/2]+"");
		bw.close();

	}

}
