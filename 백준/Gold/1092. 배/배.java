import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] crain=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			crain[i]=Integer.parseInt(st.nextToken());
		}
		
		int M=Integer.parseInt(br.readLine());
		int[] box=new int[M];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			box[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(crain);
		Arrays.sort(box);
		
		int[] idx=new int[N];
		Arrays.fill(idx, M-1);
		
		int answer=0;
		if(crain[N-1]<box[M-1]) {
			answer=-1;
		}
		else {
			L:while(true) {
				for(int i=N-1;i>=0;i--) {
					int c=crain[i];
					for(int j=idx[i];j>=0;j--) {
						int b=box[j];
						idx[i]--;
						if(b==0) continue;
						if(c>=b) {
							box[j]=0;
							M--;
							if(M==0) {
								answer++;
								break L;
							}
							else break;
						}
					}
				}
				answer++;
			}
		}
		bw.write(answer+"");
		bw.close();

	}

}
