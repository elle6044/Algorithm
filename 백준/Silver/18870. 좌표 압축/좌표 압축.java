import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] array=new int[N];
		
		
		Set<Integer> set=new HashSet();
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int input=Integer.parseInt(st.nextToken());			
			set.add(input);
			array[i]=input;
		}
		
		int[] sorted=new int[set.size()];
		int idx=0;
		for(int a:set) {
			sorted[idx++]=a;
		}
		
		Arrays.sort(sorted);
		
		for(int i=0;i<N;i++) {
			bw.write(Arrays.binarySearch(sorted, array[i])+" ");
		}
		bw.close();
	}

}
