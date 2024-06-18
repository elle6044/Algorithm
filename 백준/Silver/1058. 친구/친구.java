import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		char[][] map=new char[N][N];
		for(int i=0;i<N;i++) {
			String input=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=input.charAt(j);
			}
		}
		
		int answer=0;
		for(int i=0;i<N;i++) {
			boolean[] v=new boolean[N];
			for(int j=0;j<N;j++) {
				if(map[i][j]=='Y') {
					v[j]=true;
					for(int k=0;k<N;k++) {
						if(map[j][k]=='Y') {
							v[k]=true;
						}
					}
				}
			}
			v[i]=false;
			int cnt=0;
			for(int j=0;j<N;j++) {
				if(v[j]) cnt++;
			}
			answer=Math.max(answer, cnt);
			
		}
		
		bw.write(answer+"");
		bw.close();

	}

}
