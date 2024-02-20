import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dc={-1,0,1};

    public static void main(String[] args) throws Exception {
        int n=nextInt();
        byte[][] map=new byte[n][3];
        int[][] dpMax=new int[n][3];
        int[][] dpMin=new int[n][3];
        for (int[] ints : dpMin) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                map[i][j]= (byte) nextInt();
            }
        }
        for(int i=0;i<3;i++){
            dpMax[0][i]=map[0][i];
            dpMin[0][i]=map[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                for(int d=0;d<3;d++){
                    int nr=i-1;
                    int nc=j+dc[d];
                    if(nc>=0&&nc<3){
                        dpMax[i][j]=Math.max(dpMax[i][j],dpMax[nr][nc]+map[i][j]);
                        dpMin[i][j]=Math.min(dpMin[i][j],dpMin[nr][nc]+map[i][j]);
                    }
                }
            }
        }

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            max=Math.max(max,dpMax[n-1][i]);
            min=Math.min(min,dpMin[n-1][i]);
        }
        bw.write(max+" "+min);

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
