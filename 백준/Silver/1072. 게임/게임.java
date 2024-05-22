import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		st=new StringTokenizer(br.readLine());
		long X=Integer.parseInt(st.nextToken());
		long Y=Integer.parseInt(st.nextToken());
		long Z=Y*100/X;
		
		long high=X;
		long low=1;
		long answer=-1;
		
		while(high>=low) {
			long mid=(high+low)/2;
			long avg=(Y+mid)*100/(X+mid);
			
			if(avg>Z) {
				answer=mid;
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
