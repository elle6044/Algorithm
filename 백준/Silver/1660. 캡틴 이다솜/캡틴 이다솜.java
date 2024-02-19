import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int[] dp=new int[122];
        dp[1]=1;
        for(int i=2;i<=121;i++){
            dp[i]=dp[i-1]+(i%2==0?(i+1)*(i/2):(i+1)/2*i);
        }

        int n=Integer.parseInt(br.readLine());
        int[] dp2=new int[n+1];
        for(int i=1;i<=n;i++){
            dp2[i]=i;
        }

        for(int k=2;true;k++){
            int num=dp[k];
            if(num>n) break;
            for(int i=num;i<=n;i++){
                dp2[i]=Math.min(dp2[i],1+dp2[i-num]);
            }
        }

        bw.write(dp2[n]+"");
        bw.close();
    }
}
