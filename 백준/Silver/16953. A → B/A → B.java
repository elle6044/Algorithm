import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		
		int cnt=1;
		while(B>A) {
			if(B%10==1) {
				B/=10;
			}
			else if(B%2==0) {
				B/=2;
			}
			else {
				break;
			}
			cnt++;
		}
		
		if(A!=B) {
			cnt=-1;
		}
		bw.write(cnt+"");
		bw.close();
	}

}
