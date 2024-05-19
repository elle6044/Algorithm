import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int G=Integer.parseInt(br.readLine());
		int P=Integer.parseInt(br.readLine());
		
		boolean[] gate=new boolean[G+1];
		int[] num=new int[100001];
		
		int answer=0;
		L:for(int i=0;i<P;i++) {
			int p=Integer.parseInt(br.readLine());
			for(int j=num[p]==0?p:num[p]-1;j>=1;j--) {
				if(!gate[j]) {
					gate[j]=true;
					answer++;
					num[p]=j;
					continue L;
				}
			}
			break;
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
