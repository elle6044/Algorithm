import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int d=nextInt();
        int k=nextInt();
        int[] dp=new int[d+1];
        dp[2]=1;
        dp[3]=1;
        for(int i=4;i<=d;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        int one=dp[d-1];
        int two=dp[d-1]+dp[d-2];
        L:for(int i=1;i<=k;i++){
            for(int j=1;j<=k;j++){
                if(one*i+two*j==k){

                    if(i<=j){
                        if(j*(two-one)+(i+j)*one==k){
                            bw.write(i+"\n"+j);
                            break L;
                        }
                    }
                }
            }
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
