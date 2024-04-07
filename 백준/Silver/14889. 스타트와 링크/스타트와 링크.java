import java.io.*;
import java.util.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[][] map;
	static int allSum=0;
	
	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				allSum+=map[i][j];
			}
		}
		back(0);
		
		bw.write(answer+"");
		bw.close();
	}
	static Set<Integer>set=new HashSet();
	static int answer=Integer.MAX_VALUE;
	public static void back(int idx) {
		if(set.size()==N/2) {
			
			int sum=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(set.contains(i)&&set.contains(j)) {
						sum+=map[i][j];
					}
					else if(!set.contains(i)&&!set.contains(j)) {
						sum-=map[i][j];
					}
				}
			}
			answer=Math.min(answer, Math.abs(sum));
			return;
		}
		if(idx==N) return;
		
		set.add(idx);
		back(idx+1);
		set.remove(idx);
		back(idx+1);
	}

}
