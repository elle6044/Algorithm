import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map=new int[5][5];
    static int[] dr={1,-1,0,0};
    static int[] dc={0,0,1,-1};

    public static void main(String[] args) throws Exception {
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                map[i][j]=nextInt();
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                back(i,j,0,map[i][j]);
            }
        }

        bw.write(set.size()+"");
        bw.close();
    }

    static Set<Integer> set=new HashSet<>();
    private static void back(int r, int c, int cnt, int sum) {
        if(cnt==5){
            set.add(sum);
            return;
        }

        for(int d=0;d<4;d++){
            int nr=r+dr[d];
            int nc=c+dc[d];
            if(nr>=0&&nr<5&&nc>=0&&nc<5){
                back(nr,nc,cnt+1,sum*10+map[nr][nc]);
            }
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
