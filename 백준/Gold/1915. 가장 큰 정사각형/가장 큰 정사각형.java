import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int m=nextInt();
        int[][] map=new int[n][m];
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            String input=br.readLine();
            for(int j=0;j<m;j++){
                map[i][j]=Character.getNumericValue(input.charAt(j));
                dp[i][j]=map[i][j];
            }
        }

        for(int i=1;i<n;i++){
            L:for(int j=1;j<m;j++){
                if(map[i][j]==1){
                    for(int k=1;k<=dp[i-1][j-1];k++){
                        if(map[i-k][j]!=1||map[i][j-k]!=1){
                            dp[i][j]=k;
                            continue L;
                        }
                    }
                    dp[i][j]=dp[i-1][j-1]+1;
                }

            }
        }
        
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max=Math.max(max,dp[i][j]);
            }
        }
        bw.write((int)Math.pow(max,2)+"");
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
