import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int k=nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=nextInt();
        }

        int[] dp=new int[k+1];
        for (int coin : array) {
            for(int i=coin;i<=k;i++){
                if(i-coin==0){
                    dp[i]++;
                }
                else{
                    dp[i]+=dp[i-coin];
                }
            }
        }

        bw.write(dp[k]+"");
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
