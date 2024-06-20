import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static Map<String, Integer> monthMap=new HashMap();
	static String[] month= {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	static int[] day= {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) throws Exception {
		for(int i=1;i<=12;i++) {
			monthMap.put(month[i], i);
		}
		
		String input=br.readLine();
		String[] words=input.split("[ ,:]");
		
		
		int y=Integer.parseInt(words[3]);
		int m=monthMap.get(words[0]);
		int d=Integer.parseInt(words[1]);
		int hour=Integer.parseInt(words[4]);
		int min=Integer.parseInt(words[5]);
		
		
		
		boolean check=false;
		if((y%4==0&&y%100!=0)||y%400==0) {
			check=true;
		}
		
		double all=check?366*24*60:365*24*60;
		double sum=0;
		for(int i=1;i<m;i++) {
			sum+=day[i]*24*60;
		}
		sum+=(d-1)*24*60;
		sum+=hour*60;
		sum+=min;
		if(m>2&&check) {
			sum+=24*60;
		}
		double answer=sum/all*100;
		bw.write(answer+"");
		bw.close();
		
	}

}
