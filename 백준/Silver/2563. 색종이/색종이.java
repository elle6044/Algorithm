import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N=nextInt();
        boolean[][] map=new boolean[101][101];

        int cnt=0;
        for(int i=0;i<N;i++){
            int sx=nextInt();
            int sy=nextInt();
            int ex=sx+10;
            int ey=sy+10;


            for(int x=sx;x<ex;x++){
                for(int y=sy;y<ey;y++){
                    if(!map[x][y]){
                        cnt++;
                        map[x][y]=true;
                    }
                }
            }
        }
        bw.write(cnt+"");
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
