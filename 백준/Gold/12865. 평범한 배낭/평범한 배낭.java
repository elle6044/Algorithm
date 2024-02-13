import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int k=nextInt();
        int[] weight=new int[n+1];
        int[] score=new int[n+1];
        for(int i=1;i<=n;i++){
            weight[i]=nextInt();
            score[i]=nextInt();
        }

        int[][]dp=new int[n+1][k+1];
        Arrays.fill(dp[0],0);

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(weight[i]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+score[i]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        bw.write(dp[n][k]+"");
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
