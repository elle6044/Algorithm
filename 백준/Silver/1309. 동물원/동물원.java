import java.io.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=3;
        if(n>=2){
            for(int i=2;i<=n;i++){
                dp[i]=(dp[i-1]*2+dp[i-2])%9901;
            }
        }

        bw.write(dp[n]+"");
        bw.close();
    }
}
