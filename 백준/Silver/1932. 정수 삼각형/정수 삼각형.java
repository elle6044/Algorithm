import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int[] array=new int[(n+1)*(n/2)+((n+1)/2)*(n%2==0?0:1)+1];
        for(int i=1;i<array.length;i++){
            array[i]=nextInt();
        }

        int[] dp=new int[array.length];
        dp[1]=array[1];

        int cnt=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                cnt++;
                dp[cnt]=array[cnt];
                if(j==0){
                    dp[cnt]+=dp[cnt-i+1];
                }
                else if(j==i-1){
                    dp[cnt]+=dp[cnt-i];
                }
                else{
                    dp[cnt]+=Math.max(dp[cnt-i+1],dp[cnt-i]);
                }
            }
        }

        int max=0;
        for(int i=0;i<dp.length;i++){
            max=Math.max(max,dp[i]);
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
