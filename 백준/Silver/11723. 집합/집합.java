import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int M=Integer.parseInt(br.readLine());
		Set<Integer> set=new HashSet();
		
		for(int m=0;m<M;m++) {
			st=new StringTokenizer(br.readLine());
			String com=st.nextToken();
			if(com.equals("add")) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			else if(com.equals("remove")) {
				set.remove(Integer.parseInt(st.nextToken()));
			}
			else if(com.equals("check")) {
				if(set.contains(Integer.parseInt(st.nextToken()))) {
					bw.write("1\n");
				}
				else {
					bw.write("0\n");
				}
			}
			else if(com.equals("toggle")) {
				int num=Integer.parseInt(st.nextToken());
				if(set.contains(num)) {
					set.remove(num);
				}
				else{
					set.add(num);
				}
			}
			else if(com.equals("all")) {
				set.clear();
				for(int i=1;i<=20;i++) {
					set.add(i);
				}
			}
			else if(com.equals("empty")) {
				set.clear();
			}
		}
		bw.close();
	}

}
