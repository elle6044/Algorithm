import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int k=nextInt();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nextInt());
        }

        int[] dp=new int[k+1];
        Arrays.fill(dp,10001);
        dp[0]=0;

        for( int coin : set){
            for(int i=coin;i<=k;i++){
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }



        if(dp[k]==10001){
            bw.write("-1");
        }
        else{
            bw.write(dp[k]+"");
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
