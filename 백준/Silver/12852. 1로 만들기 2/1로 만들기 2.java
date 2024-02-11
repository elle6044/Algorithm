import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+1];
        int[] prev=new int[n+1];

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+1;
            prev[i]=i-1;

            if(i%3==0){
                if(dp[i/3]+1<dp[i]){
                    dp[i]=dp[i/3]+1;
                    prev[i]=i/3;
                }
            }
            if(i%2==0){
                if(dp[i/2]+1<dp[i]){
                    dp[i]=dp[i/2]+1;
                    prev[i]=i/2;
                }
            }
        }

        bw.write(dp[n]+"\n");
        bw.write(n+" ");
        while(n>1){
            int num=prev[n];
            bw.write(num+" ");
            n=num;
        }

        bw.close();
    }
}
