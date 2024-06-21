import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int answer=0;
		if((N%4==0&&N%100!=0)||N%400==0) {
			answer=1;
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
