import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        String input=br.readLine();
        int[] dp=new int[n];
        Arrays.fill(dp, 1000000);
        dp[0]=0;

        for(int i=1;i<n;i++){
            char now=input.charAt(i);
            for(int j=0;j<i;j++){
                char prev=input.charAt(j);
                if((now=='B'&&prev=='J')||
                        (now=='O'&&prev=='B')||
                        (now=='J'&&prev=='O')){
                    dp[i]=Math.min(dp[i],dp[j]+(int)Math.pow(i-j,2));
                }
            }
        }

        if(dp[n-1]>=1000000){
            bw.write("-1");
        }
        else{
            bw.write(dp[n-1]+"");
        }
        bw.close();
    }
}
