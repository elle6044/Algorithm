import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		while(true) {
			st=new StringTokenizer(br.readLine());
			String name=st.nextToken();
			int age=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			
			if(name.equals("#")&&age==0) break;
			
			String answer="Junior";
			if(age>17||w>=80) {
				answer="Senior";
			}
			
			bw.write(name+" "+answer+"\n");
		}
		bw.close();
	}

}
