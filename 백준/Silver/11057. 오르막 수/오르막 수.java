import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int[] array=new int[10];
        for(int i=0;i<10;i++){
            array[i]=1;
        }
        int[] dp=new int[n+1];
        dp[1]=10;

        for(int i=2;i<=n;i++){
            int start=1;

            for(int j=8;j>=0;j--){
                start+=array[j];
                array[j]=start%10007;
                dp[i]+=start;
            }
            dp[i]+=1;
            dp[i]%=10007;
        }
        bw.write(dp[n]+"");
        bw.close();
    }
}
