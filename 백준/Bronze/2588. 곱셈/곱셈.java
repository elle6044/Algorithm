import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int A=Integer.parseInt(br.readLine());
		int B=Integer.parseInt(br.readLine());
		int temp=B;
		while(temp>0) {
			int c=temp%10;
			temp/=10;
			bw.write(A*c+"\n");
		}
		bw.write(A*B+"");
		bw.close();
	}

}
