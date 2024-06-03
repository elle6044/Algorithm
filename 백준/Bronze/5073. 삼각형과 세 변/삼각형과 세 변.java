import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static String[] word= {"Invalid","Equilateral","Isosceles","Scalene"};
	public static void main(String[] args) throws Exception {
		int[] array=new int[3];
		String answer="";
		while(true) {
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<3;i++) {
				array[i]=Integer.parseInt(st.nextToken());
			}
			if(array[0]==0&&array[1]==0&&array[2]==0) {
				break;
			}
			
			Arrays.sort(array);
			if(array[2]>=array[1]+array[0]) {
				answer=word[0];
			}
			else {
				int cnt=1;
				for(int i=1;i<3;i++) {
					if(array[i]!=array[i-1]) {
						cnt++;
					}
				}
				answer=word[cnt];
			}
			
			bw.write(answer+"\n");
		}
		bw.close();

	}

}
