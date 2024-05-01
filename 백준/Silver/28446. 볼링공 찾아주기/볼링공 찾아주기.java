import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int M=Integer.parseInt(br.readLine());
		Map<Integer,Integer> map=new HashMap();
		
		for(int m=0;m<M;m++) {
			st=new StringTokenizer(br.readLine());
			int  input=Integer.parseInt(st.nextToken());
			if(input==1) {
				int x=Integer.parseInt(st.nextToken());
				int w=Integer.parseInt(st.nextToken());
				map.put(w, x);
			}
			else {
				int w=Integer.parseInt(st.nextToken());
				bw.write(map.get(w)+"\n");
			}
		}
		bw.close();
	}

}
