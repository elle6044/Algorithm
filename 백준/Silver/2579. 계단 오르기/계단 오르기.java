import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int[] array=new int[n+1];
        for(int i=1;i<=n;i++){
            array[i]=nextInt();
        }

        int[] dp=new int[n+1];
        dp[1]=array[1];
        if(n>=2){
            dp[2]=array[1]+array[2];
        }
        for(int i=3;i<=n;i++){
            dp[i]=array[i];
            dp[i]+=Math.max(dp[i-2],dp[i-3]+array[i-1]);
        }

        bw.write(dp[n]+"");
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
