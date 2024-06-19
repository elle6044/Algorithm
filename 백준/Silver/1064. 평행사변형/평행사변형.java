import java.io.*;
import java.util.*;
public class Main {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st=new StringTokenizer(br.readLine());
		
		double x1=Double.parseDouble(st.nextToken());
		double y1=Double.parseDouble(st.nextToken());
		double x2=Double.parseDouble(st.nextToken());
		double y2=Double.parseDouble(st.nextToken());
		double x3=Double.parseDouble(st.nextToken());
		double y3=Double.parseDouble(st.nextToken());
		
		double answer=-1;
		if((x1-x2)*(y2-y3)!=(x2-x3)*(y1-y2)) {
			double[] dist=new double[3];
			dist[0]=Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
			dist[1]=Math.sqrt(Math.pow(x2-x3, 2)+Math.pow(y2-y3, 2));
			dist[2]=Math.sqrt(Math.pow(x1-x3, 2)+Math.pow(y1-y3, 2));
			Arrays.sort(dist);
			
			double min=(dist[0]+dist[1])*2;
			double max=(dist[1]+dist[2])*2;
			answer=max-min;
		}
		
		bw.write(answer+"");
		bw.close();
	}

}
