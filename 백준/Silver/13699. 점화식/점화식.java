import java.io.*;
import java.math.BigInteger;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        BigInteger[] dp=new BigInteger[n+1];
        dp[0]=new BigInteger("1");
        for(int i=1;i<=n;i++){
            BigInteger num=new BigInteger("0");
            for(int j=0;j<i;j++){
                num=num.add(dp[j].multiply(dp[i-j-1]));
            }
            dp[i]=num;
        }
        bw.write(dp[n]+"");
        bw.close();
    }
}
