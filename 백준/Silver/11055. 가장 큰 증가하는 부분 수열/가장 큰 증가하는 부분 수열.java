import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int[] array=new int[n];
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            array[i]=nextInt();
            dp[i]=array[i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(array[i]>array[j]){
                    dp[i]=Math.max(dp[i],dp[j]+array[i]);
                }
            }
        }
        int max=dp[0];
        for (int i : dp) {
            max=Math.max(max,i);
        }
        bw.write(max+"");
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
