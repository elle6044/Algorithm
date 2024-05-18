import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[] array;
	
	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int input=Integer.parseInt(st.nextToken());
			array[i]=input;
		}
		Arrays.sort(array);
		
		int num=1;
		if(array[0]==1) {
			for(int i=1;i<N;i++) {
				int next=array[i];
				if(next<=num+1) {
					num+=next;
				}
				else {
					break;
				}
			}
			num++;
		}
		
		bw.write(num+"");
		bw.close();
	}
}
