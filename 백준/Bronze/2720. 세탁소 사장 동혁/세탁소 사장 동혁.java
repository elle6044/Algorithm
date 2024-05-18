import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] coins= {25,10,5,1};
	static int[] answer;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			answer=new int[4];
			int money=Integer.parseInt(br.readLine());
			for(int i=0;i<4;i++) {
				if(money>=coins[i]) {
					answer[i]+=money/coins[i];
					money%=coins[i];
				}
			}
			for(int a:answer) {
				bw.write(a+" ");
			}
			bw.write("\n");
		}
		bw.close();
	}

}
