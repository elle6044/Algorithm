import java.util.*;
import java.io.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		Set<Integer> set=new TreeSet();
		for(int i=0;i<N;i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		
		for(int a:set) {
			bw.write(a+"\n");
		}
		bw.close();

	}

}
