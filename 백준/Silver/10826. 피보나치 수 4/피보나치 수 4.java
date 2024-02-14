import java.io.*;
import java.math.BigInteger;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        BigInteger[] dp=new BigInteger[n+3];
//        long[] dp=new long[n+3];
        dp[0]=new BigInteger("0");
        dp[1]=new BigInteger("1");
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-2].add(dp[i-1]);
        }
        bw.write(dp[n]+"");
        bw.close();
    }
}
