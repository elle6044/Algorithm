import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dr={1,0,1};
    static int[] dc={0,1,1};

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        int m=nextInt();
        int[][] map=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=nextInt();
            }
        }
        int[][] dp=new int[n][m];
        dp[0][0]=map[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int d=0;d<3;d++){
                    int nr=i+dr[d];
                    int nc=j+dc[d];
                    if(nr>=0&&nr<n&&nc>=0&&nc<m){
                        dp[nr][nc]=Math.max(dp[nr][nc],dp[i][j]+map[nr][nc]);
                    }
                }
            }
        }

        bw.write(dp[n-1][m-1]+"");
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
