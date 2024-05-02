import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[] map;
	static Set<Integer> set=new HashSet();
	
	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		map=new int[N];
		st=new StringTokenizer(br.readLine());
		int max=0;
		for(int i=0;i<N;i++) {
			map[i]=Integer.parseInt(st.nextToken());
			max+=map[i];
		}
		
		back(0,0);

		bw.write((max-set.size())+"");
		bw.close();
	}

	static void back(int idx, int sum) {
		if(idx==N) {
			if(sum==0) return;
			set.add(sum);
			return;
		}
		
		back(idx+1, sum+map[idx]);
		back(idx+1, sum);
	}
}
