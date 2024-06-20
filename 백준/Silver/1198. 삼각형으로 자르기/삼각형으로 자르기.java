import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[][] array;
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		array=new int[N][2];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			array[i][0]=Integer.parseInt(st.nextToken());
			array[i][1]=Integer.parseInt(st.nextToken());
		}
		
		recursive(0,0,new int[3]);
		bw.write(answer+"");
		bw.close();
	}
	
	static double answer=0;
	static void recursive(int cnt, int idx, int[] point) {
		if(cnt==3) {
			double temp=Math.abs(array[point[0]][0]*(array[point[1]][1]-array[point[2]][1])
					+array[point[1]][0]*(array[point[2]][1]-array[point[0]][1])
					+array[point[2]][0]*(array[point[0]][1]-array[point[1]][1]))*0.5;
			answer=Math.max(answer, temp);
			return;
		}
		if(idx==N) return;
		
		point[cnt]=idx;
		recursive(cnt+1, idx+1, point);
		recursive(cnt, idx+1, point);
	}

}
