import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[] array=new int[M];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		
		int answer=0;
		
		int left=0;
		int right=M-1;
		int low=Math.min(array[left], array[right]);
		
		while(left<right) {
			int l=array[left];
			int r=array[right];
			
			if(r<l) {
				right--;
				if(r<=low) {
					answer+=low-r;
				}
				else {
					low=r;
				}
			}
			else {
				left++;
				if(l<=low) {
					answer+=low-l;
				}
				else {
					low=l;
				}
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
