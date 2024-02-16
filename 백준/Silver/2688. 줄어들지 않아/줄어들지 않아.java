import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int T=nextInt();
        long[] dp=new long[65];
        long[] array={1,1,1,1,1,1,1,1,1,1};
        dp[1]=10;
        for(int i=2;i<65;i++){
            long temp=array[0];
            array[0]=dp[i-1];

            long sum=array[0];
            for(int j=1;j<10;j++){
                long newNum=array[j-1]-temp;
                temp=array[j];
                array[j]=newNum;
                sum+=array[j];
            }
            dp[i]=sum;
        }

        for(int t=0;t<T;t++){
            int n=nextInt();
            bw.write(dp[n]+"\n");
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
