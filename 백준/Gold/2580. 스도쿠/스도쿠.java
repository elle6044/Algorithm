import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map=new int[9][9];
    static int zeroCnt=0;


    public static void main(String[] args) throws Exception {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int input=nextInt();
                map[i][j]=input;
                if(input==0) zeroCnt++;
            }
        }

        back(0,0,0);

        bw.close();

    }

    static boolean isEnd=false;
    private static void back(int r, int c, int cnt) throws IOException {
        if(cnt==zeroCnt){
            for (int[] ints : map) {
                for (int i : ints) {
                    bw.write(i+" ");
                }
                bw.write("\n");
            }
            isEnd=true;
            return;
        }

        for(int i=r;i<9;i++){
            for(int j=0;j<9;j++){
                if (isEnd) return;
                if(map[i][j]==0){
                    for(int num=1;num<=9;num++){
                        if(isPossible(i,j,num)){
                            map[i][j]=num;
                            back(r,c,cnt+1);
                            map[i][j]=0;
                        }
                        if (isEnd) return;
                    }
                    if(map[i][j]==0)return;
                }
            }
        }
    }

    private static Set<Integer> getNums(int r, int c) {
        Set<Integer> set=new HashSet<>();
        for(int i=1;i<=9;i++){
            set.add(i);
        }

        for(int i=0;i<9;i++){
            set.remove(map[r][i]);
            set.remove(map[i][c]);
        }

        int nr=r/3*3;
        int nc=c/3*3;
        for(int i=nr;i<nr+3;i++){
            for(int j=nc;j<nc+3;j++){
                set.remove(map[nr][nc]);
            }
        }
        return set;
    }

    private static boolean isPossible(int r, int c, int num) {
        for(int i=0;i<9;i++){
            if(map[r][i]==num||map[i][c]==num){
                return false;
            }
        }

        int nr=r/3*3;
        int nc=c/3*3;
        for(int i=nr;i<nr+3;i++){
            for(int j=nc;j<nc+3;j++){
                if(map[i][j]==num){
                    return false;
                }
            }
        }

        return true;
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
