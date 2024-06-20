import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		int[] array=new int[N];
		Arrays.fill(array, -1);
		Set<Character> set=new HashSet();
		
		StringBuilder sb=new StringBuilder();
		L:for(int i=0;i<N;i++) {
			String input=br.readLine();
			String[] words=input.split(" ");
			int idx=0;
			for(String word:words) {
				char a=word.charAt(0);
				if(!set.contains(Character.toLowerCase(a))&&!set.contains(Character.toUpperCase(a))) {
					array[i]=idx;
					set.add(a);
					sb.append(input.substring(0,idx)).append("[").append(a).append("]").append(input.substring(idx+1)).append("\n");
					continue L;
				}
				idx+=word.length()+1;
			}
			
			for(int j=0;j<input.length();j++) {
				char a=input.charAt(j);
				if(a==' ') continue;
				if(!set.contains(Character.toLowerCase(a))&&!set.contains(Character.toUpperCase(a))) {
					array[i]=j;
					set.add(a);
					sb.append(input.substring(0,j)).append("[").append(a).append("]").append(input.substring(j+1)).append("\n");
					continue L;
				}
			}
			
			sb.append(input).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}

}
