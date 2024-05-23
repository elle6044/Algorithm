import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[] array;
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		array=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		int left=0;
		int right=N-1;
		
		int min=Integer.MAX_VALUE;
		int mleft=0;
		int mright=N-1;
		
		while(left<right) {
			int l=array[left];
			int r=array[right];
			int sum=l+r;
			if(Math.abs(l+r)<min) {
				min=Math.abs(l+r);
				mleft=l;
				mright=r;
			}
			if(sum<0) {
				++left;
			}
			else if(sum>0) {
				--right;
			}
			else {
				break;
			}
		}
		
		bw.write(mleft+" "+mright);
		bw.close();
	}

}
