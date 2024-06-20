import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		boolean[][] v=new boolean[6][6];
		String answer="Valid";
		
		String first=br.readLine();
		int sr=Character.getNumericValue(first.charAt(1))-1;
		int sc=first.charAt(0)-65;
		
		int tr=sr;
		int tc=sc;
		v[tr][tc]=true;
		
		for(int i=0;i<35;i++) {
			String input=br.readLine();
			int r=Character.getNumericValue(input.charAt(1))-1;
			int c=input.charAt(0)-65;
			
			if(v[r][c]) {
				answer="Invalid";
				break;
			}
			if(!(Math.abs(tr-r)==2&&Math.abs(tc-c)==1)&&!(Math.abs(tr-r)==1&&Math.abs(tc-c)==2)) {
				answer="Invalid";
				break;
			}
			v[r][c]=true;
			tr=r;
			tc=c;
		}
		
		if(!(Math.abs(tr-sr)==2&&Math.abs(tc-sc)==1)&&!(Math.abs(tr-sr)==1&&Math.abs(tc-sc)==2)) {
			answer="Invalid";
		}
		
		bw.write(answer);
		bw.close();

	}

}
