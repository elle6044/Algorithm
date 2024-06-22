import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Set<Integer> set=new HashSet();
	public static void main(String[] args) throws Exception{
		int N=Integer.parseInt(br.readLine());
		
		int size=0;
		int first=Integer.parseInt(br.readLine());
		int temp=first;
		for(int i=1;i<N;i++) {
			int next=Integer.parseInt(br.readLine());
			set.add(next-temp);
			temp=next;
			size=next-first;
		}
		
		Queue<Integer>q=new ArrayDeque(set);
		int gcd=q.poll();
		while(!q.isEmpty()) {
			int next=q.poll();
			gcd=getGCD(gcd,next);
		}
		
		int answer=size/gcd+1-N;
		bw.write(answer+"");
		bw.close();
	}
	
	static int getGCD(int a, int b) {
		if(a%b==0) {
			return b;
		}
		return getGCD(b,a%b);
	}

}
