import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static Map<String, Integer> map=new HashMap();
	static String[] day= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	static int[] num= {7,6,5,4,3,2,1};
	
	public static void main(String[] args) throws Exception{
		for(int i=0;i<7;i++) {
			map.put(day[i], num[i]);
		}
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String input=br.readLine();
			bw.write("#"+t+" "+map.get(input)+"\n");
		}
		bw.close();
	}

}
