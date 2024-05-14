import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int P=Integer.parseInt(br.readLine());
		List<Integer> list=new ArrayList();
		for(int p=1;p<=P;p++) {
			st=new StringTokenizer(br.readLine());
			st.nextToken();
			
			list.add(Integer.parseInt(st.nextToken()));
			
			int cnt=0;
			L:for(int i=1;i<20;i++) {
				int now=Integer.parseInt(st.nextToken());
				for(int j=0;j<i;j++) {
					int pre=list.get(j);
					if(now<pre) {
						list.add(j, now);
						cnt+=i-j;
						continue L;
					}
				}
				list.add(now);
			}
			bw.write(p+" "+cnt+"\n");
			list.clear();
		}

		
		bw.close();
	}

}
