import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BigInteger[] dp=new BigInteger[251];
        dp[0]=new BigInteger("1");
        dp[1]=new BigInteger("1");
        dp[2]=new BigInteger("3");
        for(int i=3;i<=250;i++){
            dp[i]=dp[i-2].multiply(new BigInteger("2")).add(dp[i-1]);
        }
        String input;
        while((input=br.readLine())!=null&&!input.isEmpty()){
            bw.write(dp[Integer.parseInt(input)]+"\n");
        }
        bw.close();
    }
}
