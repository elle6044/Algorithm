import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=nextInt();
        }

        boolean[][] dp=new boolean[n][n];
        for (boolean[] booleans : dp) {
            Arrays.fill(booleans,true);
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(i-j==1){
                    if(array[i]!=array[j]){
                        dp[j][i]=false;
                    }
                }
                else{
                    if(array[i]!=array[j]||
                    !dp[j+1][i-1]){
                        dp[j][i]=false;
                    }
                }
            }
        }

        int m=nextInt();
        for(int i=0;i<m;i++){
            int s=nextInt()-1;
            int e=nextInt()-1;
            bw.write((dp[s][e]?"1":"0")+"\n");
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
