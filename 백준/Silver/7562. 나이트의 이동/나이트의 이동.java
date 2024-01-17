import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static boolean[][] map;
    static int r2,c2;

    public static void main(String[] args) throws Exception {
        int T=nextInt();
        for(int t=0;t<T;t++){
            N=nextInt();
            map=new boolean[N][N];
            int r1=nextInt();
            int c1=nextInt();
            r2=nextInt();
            c2=nextInt();
            bfs(r1,c1);
        }
        bw.close();
    }

    private static void bfs(int r1, int c1) throws IOException {
        Queue<Point> q=new ArrayDeque<>();
        q.offer(new Point(r1, c1, 0));
        map[r1][c1]=true;
        while(!q.isEmpty()){
            Point p=q.poll();
            if(p.r==r2&&p.c==c2){
                bw.write(p.cnt+"\n");
            }
            for(int d=0;d<8;d++){
                int nr=p.r+dr[d];
                int nc=p.c+dc[d];
                if(nr>=0&&nr<N&&nc>=0&&nc<N&&!map[nr][nc]){
                    q.offer(new Point(nr,nc,p.cnt+1));
                    map[nr][nc]=true;
                }
            }
        }
    }

    static int[] dr={-2,-1,1,2,2,1,-1,-2};
    static int[] dc={1,2,2,1,-1,-2,-2,-1};
    static class Point{
        int r,c,cnt;
        public Point(int r, int c, int cnt){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
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
