import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int T=nextInt();
        for(int t=0;t<T;t++){
            int N=nextInt();
            int M=nextInt();

            if(N==M){
                bw.write("1\n");
            }
            else{
                int[] dp=new int[N+1];
                dp[1]=M;
                for(int i=2;i<dp.length;i++){
                    dp[i]=Math.max(dp[i-1]/i*(M-i+1),dp[i-1]*(M-i+1)/i);
                }
                bw.write(dp[N]+"\n");
            }
        }
        bw.close();
    }

    static int nextInt() throws Exception {
        int sign = 0;
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        if(c == 45) {
            sign = 1;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 47 && c < 58);
        return sign == 0 ? n : ~n + 1;
    }

}
