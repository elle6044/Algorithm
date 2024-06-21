import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int answer=0;
		while(N>0) {
			int temp=N--;
			while(temp%5==0) {
				answer++;
				temp/=5;
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
