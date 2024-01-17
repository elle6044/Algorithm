import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;

    public static void main(String[] args) throws Exception {
        map=new int[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                map[i][j]=nextInt();
            }
        }

        L:for(int t=1;t<=25;t++){
            int input=nextInt();

            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(map[i][j]==input){
                        map[i][j]=0;
                        check(i,j);
                        if(cnt>=3){
                            bw.write(t+"");
                            break L;
                        }
                    }
                }
            }
        }

        bw.close();
    }

    static int cnt=0;

    private static void check(int r, int c) {
        int rCnt=0;
        int cCnt=0;
        int xCnt1=0;
        int xCnt2=0;
        for(int i=0;i<5;i++){
            if(map[r][i]==0){
                rCnt++;
            }
            if(map[i][c]==0){
                cCnt++;
            }
        }

        if(r==c){
            for(int i=0;i<5;i++){
                if(map[i][i]==0){
                    xCnt1++;
                }
            }
        }
        if(r+c==4){
            for(int i=0;i<5;i++){
                if(map[i][4-i]==0){
                    xCnt2++;
                }
            }
        }

        if(rCnt==5){
            cnt++;
        }
        if(cCnt==5){
            cnt++;
        }
        if(xCnt1==5){
            cnt++;
        }
        if(xCnt2==5){
            cnt++;
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
