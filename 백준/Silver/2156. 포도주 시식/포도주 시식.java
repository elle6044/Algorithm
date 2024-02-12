import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int[] array=new int[n+1];
        for(int i=0;i<n;i++){
            array[i]=nextInt();
        }
        int[] dp=new int[n+1];
        dp[0]=array[0];
        dp[1]=array[1]+array[0];
        if(n>=2){
            if(n >= 3) {
                dp[2] = Math.max(dp[1], Math.max(array[0] + array[2], array[1] + array[2]));
                for(int i = 3; i < n; i++){
                    dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + array[i], dp[i-3] + array[i-1] + array[i]));
                }
            }

        }

        int max=0;
        for (int i : dp) {
            max=Math.max(max,i);
        }
        bw.write(max+"");
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
