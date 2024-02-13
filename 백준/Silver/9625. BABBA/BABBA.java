import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int[][] dp=new int[n+1][2];
        dp[1][0]=0;
        dp[1][1]=1;
        for(int i=2;i<=n;i++){
            dp[i][0]=dp[i-1][1];
            dp[i][1]=dp[i-1][0]+dp[i-1][1];
        }

        bw.write(dp[n][0]+" "+dp[n][1]);
        bw.close();
    }
}
