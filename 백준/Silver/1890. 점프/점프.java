import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[][] map;
    static long[][] dp;
    static int[] dr={1,0};
    static int[] dc={0,1};

    public static void main(String[] args) throws Exception {
        n=nextInt();
        map=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j]=nextInt();
            }
        }
        dp=new long[n][n];
        dp[0][0]=1;
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(dp[r][c]>0&&map[r][c]>0){
                    for(int d=0;d<2;d++){
                        int nr=r+map[r][c]*dr[d];
                        int nc=c+map[r][c]*dc[d];
                        if(nr>=0&&nr<n&&nc>=0&&nc<n){
                            dp[nr][nc]+=dp[r][c];
                        }
                    }
                }
            }
        }

        bw.write(dp[n-1][n-1]+"");
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
