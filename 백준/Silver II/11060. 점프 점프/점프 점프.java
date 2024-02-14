import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=nextInt();
        }
        int[] dp=new int[n];
        Arrays.fill(dp, 1001);
        dp[0]=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<=array[i];j++){
                if(i+j<n){
                    dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                }
            }
        }

        bw.write(dp[n-1]>=1001?"-1":dp[n-1]+"");
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
