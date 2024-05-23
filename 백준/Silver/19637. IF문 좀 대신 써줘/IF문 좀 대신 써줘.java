import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static int[] power;
	static String[] name;
	
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		power=new int[N];
		name=new String[N];
		
		int max=0;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			name[i]=st.nextToken();
			int a=Integer.parseInt(st.nextToken());
			power[i]=a;
			max=Math.max(max, a);
		}
		
		for(int i=0;i<M;i++) {
			int p=Integer.parseInt(br.readLine());
			
			int high=N-1;
			int low=0;
			int answer=0;
			
			while(high>=low) {
				int mid=(high+low)/2;
				int mp=power[mid];
				
				if(mp>=p) {
					answer=mid;
					high=mid-1;
				}
				else {
					low=mid+1;
				}
			}
			
			bw.write(name[answer]+"\n");
		}
		bw.close();
		
		
	}

}
