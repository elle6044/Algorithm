import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		int W=Integer.parseInt(st.nextToken());
		int H=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		int Y=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		
		int R=H/2;
		
		int answer=0;
		for(int i=0;i<P;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			if(x>=X&&x<=X+W&&y>=Y&&y<=Y+H) {
				answer++;
				continue;
			}
			
			double dist1=Math.sqrt(Math.pow(x-X, 2)+Math.pow(y-(Y+R), 2));
			double dist2=Math.sqrt(Math.pow(x-(X+W), 2)+Math.pow(y-(Y+R), 2));
			
			if(dist1<=R||dist2<=R) {
				answer++;
				continue;
			}
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
