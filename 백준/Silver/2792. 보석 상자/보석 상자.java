import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static Integer[] array;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		array=new Integer[M];
		
		int high=0;
		
		for(int i=0;i<M;i++) {
			int num=Integer.parseInt(br.readLine());
			array[i]=num;
			high=Math.max(high, num);
		}
				
		int low=1;
		int mid=(high+low)/2;
		
		int answer=mid;
		
		while(true) {
			mid=(high+low)/2;
			
			boolean isPossible=Check(mid);
			
			if(isPossible) {
				high=mid-1;
				answer=mid;
			}
			else {
				low=mid+1;
			}
			
			if(high<low) break;
		}
		
		bw.write(answer+"");
		bw.close();
	}
	
	static boolean Check(int num) {
		int student=N;
		
		for(int gem:array) {
			student-=(gem/num+(gem%num==0?0:1));
			if(student<0) return false;
		}
        
		return true;
	}
}
