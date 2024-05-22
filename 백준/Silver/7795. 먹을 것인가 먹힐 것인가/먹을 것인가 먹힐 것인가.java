import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[] A;
	static int[] B;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			A=new int[N];
			B=new int[M];
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				A[i]=Integer.parseInt(st.nextToken());
			}
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				B[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(B);
			
			int answer=0;
			for(int i=0;i<N;i++) {
				int size=A[i];
				
				int high=M-1;
				int low=0;
				
				while(high>=low) {
					int mid=(high+low)/2;
					
					if(B[mid]<size) {
						answer+=mid-low+1;
						low=mid+1;
					}
					else {
						high=mid-1;
					}
				}
			}
			
			bw.write(answer+"\n");
		}
		bw.close();
	}

}
