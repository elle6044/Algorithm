import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] array=new int[N];
		Set<Integer> set=new TreeSet();
		
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int input=Integer.parseInt(st.nextToken());
			set.add(input);
			array[i]=input;
		}

		List<Integer> list=new ArrayList(set);
		Map<Integer,Integer> map=new HashMap();
		for(int i=0;i<list.size();i++) {
			map.put(list.get(i), i);
		}
		
		for(int i=0;i<N;i++) {
			bw.write(map.get(array[i])+" ");
		}
		bw.close();
	}

}
