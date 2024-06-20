import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] mon= {0,31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) throws Exception{
		int[][] array=new int[2][3];
		for(int i=0;i<2;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				array[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int answer=0;
		boolean check=false;
		
		if(array[0][0]+1000<array[1][0]) {
			check=true;
		}
		else if(array[0][0]+1000==array[1][0]) {
			if(array[0][1]<array[1][1]) {
				check=true;
			}
			else if(array[0][1]==array[1][1]) {
				if(array[0][2]<=array[1][2]) {
					check=true;
				}
			}
		}
		if(check) {
			bw.write("gg");
		}
		else {
			for(int i=array[0][0];i<=array[1][0];i++) {
				answer+=365;
				if(check(i)) answer++;
			}
			
			for(int i=1;i<array[0][1];i++) {
				answer-=mon[i];
			}
			answer-=array[0][2];
			
			for(int i=array[1][1];i<=12;i++) {
				answer-=mon[i];
			}
			answer+=array[1][2];
			
			if(array[0][0]==array[1][0]&&check(array[0][0])) {
				if(array[0][1]>=3||array[1][1]<=2) {
					answer--;
				}
			}
			else {
				if(check(array[0][0])&&array[0][1]>=3) answer--;
				if(check(array[1][0])&&array[1][1]<=2) answer--;
			}
			
			
			bw.write("D-"+answer+"");
		}
		
		bw.close();
	}
	
	static boolean check(int y) {
		boolean c=false;
		if(y%4==0) c=true;
		if(y%100==0) c=false;
		if(y%400==0) c=true;
		return c;
	}

}
