import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dc={-1,0,1};

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        byte[][] map=new byte[n+1][3];
        int[][] dp=new int[n+1][3];
        for(int i=1;i<=n;i++){
            for(int j=0;j<3;j++){
                map[i][j]= (byte) nextInt();
                dp[i][j]=map[i][j];
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<3;j++){
                for(int d=0;d<3;d++){
                    int nr=i-1;
                    int nc=j+dc[d];
                    if(nr>=0&&nr<n&&nc>=0&&nc<3){
                        dp[i][j]=Math.max(dp[i][j],dp[nr][nc]+map[i][j]);
                    }
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            max=Math.max(max,dp[n][i]);
        }
        bw.write(max+" ");

        for(int i=1;i<=n;i++){
            for(int j=0;j<3;j++){
                for(int d=0;d<3;d++){
                    int nr=i-1;
                    int nc=j+dc[d];
                    if(nr>=0&&nr<n&&nc>=0&&nc<3){
                        dp[i][j]=Math.min(dp[i][j],dp[nr][nc]+map[i][j]);
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            min=Math.min(min,dp[n][i]);
        }
        bw.write(min+"");




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
