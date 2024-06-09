import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		List[] array=new ArrayList[26];
		for(int t=0;t<T;t++) {
			String input=br.readLine();
			int K=Integer.parseInt(br.readLine());
			
			for(int i=0;i<26;i++) {
				List<Integer> list=new ArrayList();
				array[i]=list;
			}
			
			for(int i=0;i<input.length();i++) {
				int a=input.charAt(i)-97;
				array[a].add(i);
			}
			
			int min=Integer.MAX_VALUE;
			int max=Integer.MIN_VALUE;
			
			for(List<Integer> list:array) {
				if(list.size()<K) continue;
				
				int a=list.get(K-1)-list.get(0);
				int b=a;
				
				for(int i=K;i<list.size();i++) {
					int c=list.get(i)-list.get(i-K+1);
					a=Math.min(a, c);
					b=Math.max(b, c);
				}
				min=Math.min(min, a);
				max=Math.max(max, b);
			}
			if(min==Integer.MAX_VALUE) {
				bw.write("-1\n");
			}
			else {
				bw.write((min+1)+" "+(max+1)+"\n");
			}
		}
		bw.close();

	}

}
