import java.io.*;
import java.util.*;
public class Solution {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			int[] priceArray=new int[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				priceArray[i]=Integer.parseInt(st.nextToken());
			}
			
			
			long sum=0;
			int idx=0;
			
			while(true) {
				int maxPrice=0;
				int maxIdx=0;
				for(int i=idx;i<N;i++) {
					if(priceArray[i]>=maxPrice) {
						maxPrice=priceArray[i];
						maxIdx=i;
					}
				}
				
				for(int i=idx;i<=maxIdx;i++) {
					sum+=maxPrice-priceArray[i];
				}
				idx=maxIdx+1;
				if(idx==N) break;
			}
			
			bw.write("#"+t+" "+sum+"\n");
		}
		bw.close();
	}

}
