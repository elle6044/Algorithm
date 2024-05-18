import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] coins= {500,100,50,10,5,1};
	public static void main(String[] args) throws Exception{
		int money=1000-Integer.parseInt(br.readLine());
		
		int cnt=0;
		int idx=0;
		while(money>0) {
			if(money>=coins[idx]) {
				cnt+=money/coins[idx];
				money%=coins[idx];
			}
			idx++;
		}
		bw.write(cnt+"");
		bw.close();

	}

}
