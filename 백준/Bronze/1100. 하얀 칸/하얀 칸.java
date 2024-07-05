import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {
		int cnt=0;
		for(int i=0;i<8;i++) {
			String input=br.readLine();
			for(int j=0;j<8;j++) {
				char a=input.charAt(j);
				if(i%2==j%2&&a=='F') cnt++;
			}
		}
		bw.write(cnt+"");
		bw.close();
	}

}
