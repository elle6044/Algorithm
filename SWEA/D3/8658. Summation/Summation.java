import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			int[] array=new int[10];
			for(int i=0;i<10;i++) {
				int input=Integer.parseInt(st.nextToken());
				int sum=0;
				while(input>0) {
					sum+=input%10;
					input/=10;
				}
				array[i]=sum;
			}
			Arrays.sort(array);
			bw.write("#"+t+" "+array[9]+" "+array[0]+"\n");
		}
		bw.close();
	}

}
