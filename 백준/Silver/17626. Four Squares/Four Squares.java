import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int num=(int)Math.sqrt(i);
            int min=Integer.MAX_VALUE;
            for(int j=1;j<=num;j++){
                min=Math.min(min,1+dp[i-j*j]);
            }
            dp[i]=min;
        }
        
        bw.write(dp[n]+"");
        bw.close();
    }
}
