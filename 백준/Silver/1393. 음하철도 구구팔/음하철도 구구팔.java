import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int er=Integer.parseInt(st.nextToken());
		int ec=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int sr=Integer.parseInt(st.nextToken());
		int sc=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		if(r>0&&c>0) {
			int a=Math.abs(getGCD(r,c));
			r/=a;
			c/=a;
		}
		else if((r==0&&c>0)||r>0&&c==0) {
			r=r==0?0:1;
			c=c==0?0:1;
		}
		
		
		
		
		double dist=Math.sqrt(Math.pow(er-sr, 2)+Math.pow(ec-sc, 2));
		while(true) {
			double dist2=Math.sqrt(Math.pow(er-(sr+r), 2)+Math.pow(ec-(sc+c), 2));
			if(dist2>=dist) {
				break;
			}
			else {
				sr+=r;
				sc+=c;
				dist=dist2;
			}
		}
		
		bw.write(sr+" "+sc);
		bw.close();

	}
	
	static int getGCD(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGCD(b,a%b);
	}

}
