import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int[] time=new int[n+2];
        int[] money=new int[n+2];
        for(int i=1;i<=n;i++){
            time[i]=nextInt();
            money[i]=nextInt();
        }
        int[] dp=new int[n+2];

        for(int i=1;i<=n+1;i++){
            for(int j=1;j<i;j++){
                if(i-j==time[j]){
                    dp[i]=Math.max(dp[i],dp[j]+money[j]);
                }
                dp[i]=Math.max(dp[i],dp[i-1]);
            }
        }

        bw.write(dp[n+1]+"");
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
