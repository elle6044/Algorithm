import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static Map<Integer, Set<Integer>> map;
	static boolean[] v;
	static int[] answer;
	static int cnt=1;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		
		map=new HashMap();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			
			Set<Integer> set;
			if(map.containsKey(s)) {
				set=map.get(s);
			}
			else {
				set=new TreeSet();
				map.put(s, set);
			}
			set.add(e);
			
			if(map.containsKey(e)) {
				set=map.get(e);
			}
			else {
				set=new TreeSet();
				map.put(e, set);
			}
			set.add(s);
		}
		
		v=new boolean[N+1];
		v[R]=true;
		answer=new int[N+1];
		answer[R]=cnt++;
		dfs(R);
		
		for(int i=1;i<=N;i++) {
			if(!v[i]) {
				bw.write("0\n");
			}
			else {
				bw.write(answer[i]+"\n");
			}
		}
		bw.close();

	}

	static void dfs(int idx) {
		if(!map.containsKey(idx)) return;
		Set<Integer> set=map.get(idx);
		for(int a:set) {
			if(v[a]) continue;
			
			v[a]=true;
			answer[a]=cnt++;
			
			dfs(a);
		}
	}
}
