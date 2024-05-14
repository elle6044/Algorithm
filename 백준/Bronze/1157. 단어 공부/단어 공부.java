import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		String input=br.readLine();
		input=input.toUpperCase();
		int[] array=new int[26];
		
		for(int i=0;i<input.length();i++) {
			array[input.charAt(i)-65]++;
		}
		
		int mcnt=0;
		int mword=0;
		for(int i=0;i<=25;i++) {
			if(array[i]>mcnt) {
				mcnt=array[i];
				mword=i;
			}
			else if(array[i]==mcnt) {
				mword=-2;
			}
		}
		
		bw.write((char)(mword+65));
		bw.close();

	}

}
