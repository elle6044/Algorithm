import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] array=new int[9];
	static int[] answer=new int[7];
	public static void main(String[] args) throws Exception{
		for(int i=0;i<9;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);
		
		back(0,0,0);

	}
	
	static boolean check=false;
	static void back(int cnt, int idx, int sum) {
		if(check) return;
		if(cnt==7) {
			if(sum==100) {
				check=true;
				for(int a:answer) {
					System.out.println(a);
				}
			}
			return;
		}
		if(idx==9) return;
		
		answer[cnt]=array[idx];
		back(cnt+1, idx+1, sum+array[idx]);
		back(cnt, idx+1, sum);
	}

}
