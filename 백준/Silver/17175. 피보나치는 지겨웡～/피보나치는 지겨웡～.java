import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+2];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-2]+dp[i-1]+1)%1000000007;
        }
        bw.write(dp[n]+"");
        bw.close();
    }
}
