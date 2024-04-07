import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		Integer N=Integer.parseInt(br.readLine());
		int[] map=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		int B=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		long answer=0;
		for(int i=0;i<N;i++) {
			answer+=1;
			map[i]-=B;
			if(map[i]>0) {
				answer+=map[i]%C==0?map[i]/C:map[i]/C+1;
			}
		}
		bw.write(answer+"");
		bw.close();
	}

}
