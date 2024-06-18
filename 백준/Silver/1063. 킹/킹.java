import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static Map<String,Integer> dir=new HashMap();
	static String[] move= {"R","L","B","T","RT","LT","RB","LB"};
	static int[] dr= {0,0,1,-1,-1,-1,1,1};
	static int[] dc= {1,-1,0,0,1,-1,1,-1};
	public static void main(String[] args) throws Exception{
		for(int i=0;i<8;i++) {
			dir.put(move[i], i);
		}
		st=new StringTokenizer(br.readLine());
		
		String a=st.nextToken();
		String b=st.nextToken();
		int N=Integer.parseInt(st.nextToken());
		
		int kr=7-(Character.getNumericValue(a.charAt(1))-1);
		int kc=a.charAt(0)-65;

		int sr=7-(Character.getNumericValue(b.charAt(1))-1);
		int sc=b.charAt(0)-65;
		
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			int d=dir.get(input);
			int nkr=kr+dr[d];
			int nkc=kc+dc[d];
			int nsr=sr;
			int nsc=sc;
			
			if(nkr==sr&&nkc==sc) {
				nsr+=dr[d];
				nsc+=dc[d];
			}
			
			if(nkr>=0&&nkr<8&&nkc>=0&&nkc<8&&nsr>=0&&nsr<8&&nsc>=0&&nsc<8) {
				kr=nkr;
				kc=nkc;
				sr=nsr;
				sc=nsc;
			}
		}
		
		bw.write((char)(kc+65)+""+(8-kr)+"\n"+(char)(sc+65)+""+(8-sr));
		bw.close();
	}

}
