import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+2];
        dp[1]=1;
        dp[2]=3;
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-2]*2+dp[i-1])%10007;
        }
        bw.write(dp[n]+"");
        bw.close();
    }
}
