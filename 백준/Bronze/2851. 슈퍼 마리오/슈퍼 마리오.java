import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int sum=0;
		for(int i=0;i<10;i++) {
			int input=Integer.parseInt(br.readLine());
			if(Math.abs(100-sum)>=Math.abs(100-(sum+input))) {
				sum+=input;
			}
			else break;
		}
		
		bw.write(sum+"");
		bw.close();
	}

}
