import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int T=nextInt();
        for(int t=0;t<T;t++){
            int k=nextInt();
            int n=nextInt();
            int[][] dp=new int[k+1][n+1];
            for(int i=1;i<=n;i++){
                dp[0][i]=i;
            }
            for(int i=1;i<=k;i++){
                for(int j=1;j<=n;j++){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
            bw.write(dp[k][n]+"\n");
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
