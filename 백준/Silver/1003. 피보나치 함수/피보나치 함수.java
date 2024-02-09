import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int[]dp;

    public static void main(String[] args) throws Exception {
        int T=nextInt();
        for(int t=0;t<T;t++){
            int N=nextInt();
            dp=new int[N+2];
            for(int i=0;i<N+2;i++){
                dp[i]=fibo(i);
            }
            bw.write((dp[N+1]-dp[N])+" "+dp[N]+"\n");
        }
        bw.close();
    }

    private static int fibo(int num) {
        if(dp[num]!=0){
            return dp[num];
        }
        if(num==0){
            return 0;
        }
        else if(num==1){
            return 1;
        }
        else {
            return fibo(num-1)+fibo((num-2));
        }
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
