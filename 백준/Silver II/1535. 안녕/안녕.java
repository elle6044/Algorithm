import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int[] health=new int[n+1];
        int[] score=new int[n+1];
        for(int i=1;i<=n;i++){
            health[i]=nextInt();
        }
        for(int i=1;i<=n;i++){
            score[i]=nextInt();
        }
        int[][] dp=new int[n+1][100];

        for(int i=1;i<=n;i++){
            for(int j=1;j<100;j++){
                if(j>=health[i]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-health[i]]+score[i]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        bw.write(dp[n][99]+"");
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
