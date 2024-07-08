import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static String[] array;
	static boolean[] v;
	static int[] change1;
	static int[] change2;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		array=new String[N];
		for(int i=0;i<N;i++) {
			array[i]=br.readLine();
		}
		
		int len=array[0].length();
		int answer=0;
		
		for(int i=0;i<N-1;i++) {
			String a=array[i];
			v=new boolean[27];
			for(int l=0;l<len;l++) {
				int w1=a.charAt(l)-96;
				v[w1]=true;
			}
			L:for(int j=i+1;j<N;j++) {
				String b=array[j];
				change1=new int[27];
				change2=new int[27];
				for(int l=0;l<len;l++) {
					int w1=a.charAt(l)-96;
					int w2=b.charAt(l)-96;
					
					if(change1[w1]==0&&change2[w2]==0) {
						change1[w1]=w2;
						change2[w2]=w1;
					}
					else {
						if(change1[w1]!=w2||change2[w2]!=w1) {
							continue L;
						}
					}
					
				}
				answer++;
			}
		}
		bw.write(answer+"");
		bw.close();
	}

}
