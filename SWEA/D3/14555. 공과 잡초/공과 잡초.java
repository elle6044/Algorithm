import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static String input;
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
            String line = br.readLine();
            int minBalls = 0;
            boolean potentialBall = false;
            
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == '(') {
                    potentialBall = true;
                } else if (ch == ')') {
                    if (potentialBall || i > 0 && line.charAt(i - 1) == '|') {
                        minBalls++;
                        potentialBall = false;
                    }
                } else if (ch == '|' && potentialBall) {
                    minBalls++;
                    potentialBall = false;
                }
            }
            
            System.out.println("#" + t + " " + minBalls);
        }
    }
}
