import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		String input=br.readLine();
		
		int answer=0;
		char start=input.charAt(0);
		int a=0;
		int b=0;
		for(int i=1;i<N;i++) {
			char word=input.charAt(i);
			if(word==start) {
				if(b>0) {
					a++;
				}
			}
			else {
				b++;
			}
		}
		
		answer=Math.min(a, b);
		
		start=input.charAt(N-1);
		a=0;
		b=0;
		for(int i=N-2;i>=0;i--) {
			char word=input.charAt(i);
			if(word==start) {
				if(b>0) {
					a++;
				}
			}
			else {
				b++;
			}
		}
		answer=Math.min(answer, Math.min(a, b));
		bw.write(answer+"");
		bw.close();

	}

}
