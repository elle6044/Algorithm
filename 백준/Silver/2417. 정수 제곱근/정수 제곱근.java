import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static long N;
	public static void main(String[] args) throws Exception {
		N=Long.parseLong(br.readLine());
		double a=Math.sqrt(N);
		DecimalFormat df=new DecimalFormat("#.#");
		df.setMaximumFractionDigits(0);
		String result=df.format(a);
		long b=Long.parseLong(result);
		if(Math.pow(b, 2)<N) b++;
		bw.write(b+"");
		bw.close();
	}

}
