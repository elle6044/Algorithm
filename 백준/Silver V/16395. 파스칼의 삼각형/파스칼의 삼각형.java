import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int k=nextInt();
        int cnt=0;
        for(int i=1;i<=n;i++){
            cnt+=i;
        }
        int[] dp=new int[cnt+1];
        dp[1]=1;
        int idx=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                idx++;
                if(j==1||j==i){
                    dp[idx]=1;
                }
                else{
                    dp[idx]=dp[idx-i]+dp[idx-i+1];
                }
            }
        }

        bw.write(dp[cnt-n+k]+"");
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
