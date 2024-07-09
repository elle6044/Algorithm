import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		for(int t=1;t<=10;t++) {
			int N=Integer.parseInt(br.readLine());
			List<Integer> list=new ArrayList();
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int M=Integer.parseInt(br.readLine());
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				String com=st.nextToken();
				if(com.equals("I")) {
					int x=Integer.parseInt(st.nextToken());
					int y=Integer.parseInt(st.nextToken());
					
					for(int j=0;j<y;j++) {
						list.add(x+j,Integer.parseInt(st.nextToken()));
					}
				}
				else if(com.equals("D")) {
					int x=Integer.parseInt(st.nextToken());
					int y=Integer.parseInt(st.nextToken());
					
					for(int j=0;j<y;j++) {
						list.remove(x);
					}
				}
				else if(com.equals("A")) {
					int y=Integer.parseInt(st.nextToken());
					for(int j=0;j<y;j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			
			bw.write("#"+t);
			for(int i=0;i<10;i++) {
				bw.write(" "+list.get(i));
			}
			bw.write("\n");
		}
		bw.close();
	}

}
