import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int T=nextInt();
        for(int t=0;t<T;t++){
            int n=nextInt();
            int size=Math.max(n,3);
            int[] dp=new int[size+1];

            dp[1]=1;
            dp[2]=2;
            dp[3]=4;
            for(int i=4;i<=n;i++){
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }

            bw.write(dp[n]+"\n");
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
