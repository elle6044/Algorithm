import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int T=nextInt();
        for(int t=0;t<T;t++){
            int n=nextInt();
            int[] array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=nextInt();
            }
            int money=nextInt();

            int[] dp=new int[money+1];
            for(int i=0;i<n;i++){
                int coin=array[i];
                for(int j=coin;j<=money;j++){
                    if(j-coin==0){
                        dp[j]++;
                    }
                    else{
                        dp[j]+=dp[j-coin];
                    }
                }
            }
            
            bw.write(dp[money]+"\n");
        }
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
