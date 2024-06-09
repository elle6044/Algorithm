import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] array=new int[N+1];
		boolean[] v=new boolean[N+1];
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			int a=Integer.parseInt(br.readLine());
			array[i]=a;
			if(i==a) {
				v[i]=true;
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(!v[i]) {
				boolean[] tv=new boolean[N+1];
				tv=Arrays.copyOf(v, N+1);
				
				int start=i;
				int value=array[i];
				while(start!=value) {
					if(tv[value])break;
					tv[value]=true;
					value=array[value];
					if(start==value) {
						tv[i]=true;
						v=tv;
						break;
					}
				}
			}
		}
		for(int i=1;i<=N;i++) {
			if(v[i]) {
				cnt++;
			}
		}
		bw.write(cnt+"\n");
		for(int i=1;i<=N;i++) {
			if(v[i]) {
				bw.write(i+"\n");
			}
		}
		
		bw.close();
	}

}
